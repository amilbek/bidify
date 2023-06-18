package kz.bidify.authservice.controller;

import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service/api/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<AppUserDTO> getCurrentUser() {
        return ResponseEntity.ok(appUserService.getAppUser());
    }
}
