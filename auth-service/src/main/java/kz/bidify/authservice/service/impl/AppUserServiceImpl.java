package kz.bidify.authservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.bidify.authservice.config.KeycloakConfig;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.entity.AppUser;
import kz.bidify.authservice.repository.AppUserRepository;
import kz.bidify.authservice.security.AuthenticationFacade;
import kz.bidify.authservice.security.SecurityUser;
import kz.bidify.authservice.service.AppUserService;
import kz.bidify.authservice.util.ModelMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, AuthenticationFacade authenticationFacade) {
        this.appUserRepository = appUserRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public AppUserDTO getAppUser() {
        SecurityUser securityUser = authenticationFacade.getUser();
        AppUser appUser = appUserRepository.findAppUserByUsername(securityUser.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found with username " + securityUser.getUsername()));
        return ModelMapperUtil.map(appUser, AppUserDTO.class);
    }
}
