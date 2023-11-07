package kz.bidify.authservice.controller;

import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.service.AppUserService;
import kz.bidify.authservice.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth-service/api/users")
public class AppUserController {

    private final AppUserService service;

    @GetMapping
    public ResponseEntity<AppUserDTO> getCurrentUser() {
        return ResponseEntity.ok(ModelMapperUtil.map(service.getAppUser(), AppUserDTO.class));
    }
}
