package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.CustomerTokenState;
import com.example.demo.security.TokenHelper;
import com.example.demo.security.auth.JwtAuthenticationRequest;
import com.example.demo.util.common.DeviceProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nabeel on 10/17/2017.
 */
@RestController
@RequestMapping( value = "/auth", produces = {"application/json", "application/xml"} )
@Api(value="AuthenticationController", description="Customer Authentication Controller")
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DeviceProvider deviceProvider;


   // @ApiOperation(value = "Create Authentication Token", response = CustomerTokenState.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"} )
    public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response, Device device ) throws AuthenticationException, IOException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

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

    @ApiOperation(value = "Refresh Authentication Token", response = CustomerTokenState.class)
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

    @ApiOperation(value = "Logout Authentication Token")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<?> refreshAuthenticationToken() {
        // call the evit method
        Map<String,String> result =new HashMap<String,String>();
        result.put( "result", "success");

        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }



}