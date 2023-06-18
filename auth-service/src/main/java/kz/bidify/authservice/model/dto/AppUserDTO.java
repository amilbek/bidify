package kz.bidify.authservice.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {

    private UUID appUserUUID;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String username;
    private String role;
}
