package com.example.movie.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFailure implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        if (e instanceof BadCredentialsException) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Authentication Password incorrect");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Authentication Error:" + e.getMessage());
        }
    }
}