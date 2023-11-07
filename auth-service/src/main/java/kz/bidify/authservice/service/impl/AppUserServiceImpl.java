package kz.bidify.authservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.bidify.authservice.model.entity.AppUser;
import kz.bidify.authservice.repository.AppUserRepository;
import kz.bidify.authservice.security.AuthenticationFacade;
import kz.bidify.authservice.security.SecurityUser;
import kz.bidify.authservice.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository repository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public AppUser getAppUser() {
        SecurityUser securityUser = authenticationFacade.getUser();
        return repository.findAppUserByUsername(securityUser.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found with username " + securityUser.getUsername()));
    }

    @Override
    public AppUser save(AppUser appUser) {
        return repository.save(appUser);
    }

    @Override
    public boolean existsByEmailOrUsername(String email, String username) {
        return !repository.findAllByEmailOrUsername(email, username).isEmpty();
    }
}
