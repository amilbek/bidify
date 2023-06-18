package kz.bidify.authservice.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    Authentication getAuthentication();

    SecurityUser getUser();
}
