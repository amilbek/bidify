package kz.bidify.authservice.validation;

import kz.bidify.authservice.model.dto.AppUserCreateDTO;

public class PasswordConfirmationValidation {

    public static boolean isValid(AppUserCreateDTO appUserCreateDTO) {
        return appUserCreateDTO.getPassword().equals(appUserCreateDTO.getPasswordConfirmation());
    }
}
