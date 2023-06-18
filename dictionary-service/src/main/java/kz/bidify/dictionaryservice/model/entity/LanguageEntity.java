package kz.bidify.dictionaryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Data
@Builder
@Entity
@Document(collection = "language")
@AllArgsConstructor
@NoArgsConstructor
public class LanguageEntity {

    @Id
    private ObjectId id;

    private String name;

    private String code;
}
