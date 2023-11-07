package kz.bidify.authservice.facade.impl;

import kz.bidify.authservice.config.KeycloakConfig;
import kz.bidify.authservice.exception.CustomException;
import kz.bidify.authservice.facade.AuthFacade;
import kz.bidify.authservice.model.dto.AppUserCreateDTO;
import kz.bidify.authservice.model.dto.AppUserDTO;
import kz.bidify.authservice.model.dto.AuthRequestDTO;
import kz.bidify.authservice.model.entity.AppUser;
import kz.bidify.authservice.service.AppUserService;
import kz.bidify.authservice.service.EmailService;
import kz.bidify.authservice.util.ModelMapperUtil;
import kz.bidify.authservice.validation.BirthDateValidation;
import kz.bidify.authservice.validation.EmailValidation;
import kz.bidify.authservice.validation.PasswordConfirmationValidation;
import kz.bidify.authservice.validation.PasswordValidation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthFacadeImpl implements AuthFacade {

    private final AppUserService service;
    private final Keycloak keycloak;
    private final EmailService emailService;

    @Value("${keycloak.realm_id}")
    private String realmId;

    @Override
    public AccessTokenResponse login(AuthRequestDTO authRequestDTO) {
        Keycloak keycloakBuilderWithPasswordCredentials = KeycloakConfig.newKeycloakBuilderWithPasswordCredentials(authRequestDTO.getUsername(), authRequestDTO.getPassword());

        AccessTokenResponse accessTokenResponse;
        try {
            accessTokenResponse = keycloakBuilderWithPasswordCredentials.tokenManager().getAccessToken();
            return accessTokenResponse;
        } catch (BadRequestException ex) {
            throw new BadRequestException("invalid account. User probably hasn't verified email.", ex);
        }
    }

    @SneakyThrows
    @Override
    public AppUserDTO register(AppUserCreateDTO appUserCreateDTO) {
        checkUserValidations(appUserCreateDTO);
        createKeycloakUser(appUserCreateDTO);
        UserRepresentation savedUser = getUserByParameters(appUserCreateDTO.getUsername(),
                appUserCreateDTO.getFirstName(),
                appUserCreateDTO.getLastName(),
                appUserCreateDTO.getEmail());
        addRealmRoleToUser(savedUser.getId());
        AppUser appUser = AppUser
                .builder()
                .appUserUUID(UUID.fromString(savedUser.getId()))
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .birthDate(LocalDate.parse(savedUser.getAttributes().get("birthDate").get(0)))
                .email(savedUser.getEmail())
                .username(savedUser.getUsername())
                .role("USER")
                .build();
        emailService.sendVerifyEmail(savedUser.getId());
        return ModelMapperUtil.map(service.save(appUser), AppUserDTO.class);
    }

    private void checkUserValidations(AppUserCreateDTO appUserCreateDTO) {
        List<String> errors = new ArrayList<>();
        if (service.existsByEmailOrUsername(appUserCreateDTO.getEmail(), appUserCreateDTO.getUsername())) {
            errors.add("User exists with email or username");
        }
        if (!BirthDateValidation.isValid(appUserCreateDTO.getBirthDate())) {
            errors.add("User must be older than 18");
        }
        if (!EmailValidation.isValid(appUserCreateDTO.getEmail())) {
            errors.add("Email is invalid");
        }
        if (!PasswordValidation.isValid(appUserCreateDTO.getPassword())) {
            errors.add("Password is in incorrect form");
        }
        if (!PasswordConfirmationValidation.isValid(appUserCreateDTO)) {
            errors.add("Passwords do not match");
        }
        if (!errors.isEmpty()) {
            throw new CustomException(String.valueOf(errors));
        }
    }

    private void createKeycloakUser(AppUserCreateDTO appUserCreateDTO) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername(appUserCreateDTO.getUsername());
        user.setFirstName(appUserCreateDTO.getFirstName());
        user.setLastName(appUserCreateDTO.getLastName());
        user.setEmail(appUserCreateDTO.getEmail());
        user.setCredentials(Collections.singletonList(createPasswordCredentials(appUserCreateDTO.getPassword())));
        user.setEnabled(true);
        user.setAttributes(getAttributes(appUserCreateDTO));
        user.setRequiredActions(List.of("VERIFY_EMAIL"));

        keycloak.realm(realmId).users().create(user);
    }

    private UserRepresentation getUserByParameters(String username, String firstname, String lastname, String email) {
        return keycloak.realm(realmId).users().search(username,
                firstname,
                lastname,
                email,
                0, 1).get(0);
    }

    private Map<String, List<String>> getAttributes(AppUserCreateDTO appUserCreateDTO) {
        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("birthDate", List.of(appUserCreateDTO.getBirthDate().toString()));
        return attributes;
    }

    public CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }

    private void addRealmRoleToUser(String userId){
        Keycloak instance = KeycloakConfig.getInstance();
        UserResource user = instance
                .realm(realmId)
                .users()
                .get(userId);
        List<RoleRepresentation> roleRepresentationList = user
                .roles()
                .realmLevel()
                .listAvailable();
        for (RoleRepresentation roleRepresentation : roleRepresentationList) {
            if (roleRepresentation.getName().equals("USER")) {
                user.roles().realmLevel().add(List.of(roleRepresentation));
                break;
            }
        }
    }
}
