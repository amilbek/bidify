package kz.bidify.authservice.facade;

import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.dto.AuthRequestDTO;
import org.keycloak.representations.AccessTokenResponse;

public interface AuthFacade {

    AppUserDTO register(AppUserCreateDTO appUserCreateDTO);

    AccessTokenResponse login(AuthRequestDTO authRequestDTO);
}
