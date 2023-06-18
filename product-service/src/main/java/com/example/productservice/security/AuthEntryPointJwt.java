package com.example.productservice.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Level;

@Log
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        String res = authException.getMessage();
        authException.printStackTrace();;
        if (authException.getMessage().equalsIgnoreCase("Bad credentials")) {
            res = "Не правильный логин или пароль";
        }
        log.log(Level.WARNING, "Unauthorized error: {}", res);

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, res);
    }
}
