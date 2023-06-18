package kz.bidify.dictionaryservice.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    Authentication getAuthentication();

    SecurityUser getUser();
}
