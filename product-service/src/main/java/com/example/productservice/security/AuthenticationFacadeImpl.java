package com.example.productservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public SecurityUser getUser() {
        if (!getAuthentication().getPrincipal().equals("anonymousUser")) {
            CurrentUser currentUser = (CurrentUser) getAuthentication().getPrincipal();
            return currentUser.getUser();
        } else {
            return null;
        }
    }
}
