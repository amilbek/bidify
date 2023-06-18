package kz.bidify.dictionaryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Data
@Entity
@Builder
@Document(collection = "country")
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    private ObjectId id;

    private Integer countryId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private LanguageEntity lang;
}
