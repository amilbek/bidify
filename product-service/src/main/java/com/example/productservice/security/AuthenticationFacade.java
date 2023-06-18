package com.example.productservice.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    Authentication getAuthentication();

    SecurityUser getUser();
}
