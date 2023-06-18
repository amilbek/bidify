package kz.bidify.authservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Entity
@Document(collection = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    private ObjectId id;

    private UUID appUserUUID;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String username;

    private String role;
}
