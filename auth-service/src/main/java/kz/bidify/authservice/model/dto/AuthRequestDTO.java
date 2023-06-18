package kz.bidify.authservice.model.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String username;

    private String password;
}
