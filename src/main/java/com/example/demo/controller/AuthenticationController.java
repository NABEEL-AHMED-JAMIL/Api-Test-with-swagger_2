package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.CustomerTokenState;
import com.example.demo.security.TokenHelper;
import com.example.demo.security.auth.JwtAuthenticationRequest;
import com.example.demo.util.common.DeviceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Nabeel on 10/17/2017.
 */
@RestController
@RequestMapping( value = "/auth", produces = {"application/json", "application/xml"} )
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DeviceProvider deviceProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"} )
    public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response, Device device ) throws AuthenticationException, IOException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // token creation
        Customer user = (Customer)authentication.getPrincipal();
        String jws = tokenHelper.generateToken( user.getUsername(), device);
        int expiresIn = tokenHelper.getExpiredIn(device);
        // Add cookie to response
        response.addCookie( createAuthCookie( jws, expiresIn ) );
        // Return the token
        return ResponseEntity.ok(new CustomerTokenState(jws, (long) expiresIn));
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<?> refreshAuthenticationToken(
            HttpServletRequest request,
            HttpServletResponse response,
            Principal principal
            ) {

        String authToken = tokenHelper.getToken( request );

        Device device = deviceProvider.getCurrentDevice(request);

        if (authToken != null && principal != null) {

            // TODO check user password last update
            String refreshedToken = tokenHelper.refreshToken(authToken, device);
            int expiresIn = tokenHelper.getExpiredIn(device);

            // Add cookie to response
            response.addCookie( createAuthCookie( refreshedToken, expiresIn ) );

            return ResponseEntity.ok(new CustomerTokenState(refreshedToken, (long) expiresIn));
        } else {
            CustomerTokenState customerTokenState = new CustomerTokenState();
            return ResponseEntity.accepted().body(customerTokenState);
        }
    }

    private Cookie createAuthCookie(String jwt, int expiresIn) {
        Cookie authCookie = new Cookie( tokenHelper.AUTH_COOKIE, ( jwt ) );
        authCookie.setPath( "/" );
        authCookie.setHttpOnly( true );
        authCookie.setMaxAge( expiresIn );
        return authCookie;
    }
}