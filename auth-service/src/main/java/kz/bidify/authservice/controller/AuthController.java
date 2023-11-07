package kz.bidify.authservice.controller;

import kz.bidify.authservice.facade.AuthFacade;
import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.dto.AuthRequestDTO;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth-service/open-api/auth")
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> getAccessToken (@RequestBody AuthRequestDTO authRequestDTO)  {
        return ResponseEntity.ok(authFacade.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AppUserDTO> saveUser(@RequestBody AppUserCreateDTO appUserCreateDTO) {
        return ResponseEntity.ok(authFacade.register(appUserCreateDTO));
    }
}
