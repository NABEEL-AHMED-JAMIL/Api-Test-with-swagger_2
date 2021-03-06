package com.example.demo.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nabeel on 9/24/2017.
 */
@Component
public class LogoutSuccess implements LogoutSuccessHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
        response.setContentType("application/json");
        response.getWriter().write( objectMapper.writeValueAsString( result ) );
        response.setStatus(HttpServletResponse.SC_OK);

    }

}