package kz.bidify.authservice.service;

import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.dto.AuthRequestDTO;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    AppUserDTO saveAppUser(AppUserCreateDTO appUserCreateDTO);

    AccessTokenResponse login(AuthRequestDTO authRequestDTO);
}
