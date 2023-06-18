package kz.bidify.authservice.controller;

import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.dto.AuthRequestDTO;
import kz.bidify.authservice.service.AuthService;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service/open-api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> getAccessToken (@RequestBody AuthRequestDTO authRequestDTO)  {
        return ResponseEntity.ok(authService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AppUserDTO> saveUser(@RequestBody AppUserCreateDTO appUserCreateDTO) {
        return ResponseEntity.ok(authService.saveAppUser(appUserCreateDTO));
    }
}
