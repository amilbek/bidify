package kz.bidify.dictionaryservice.model.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;

@Data
@Entity
@Builder
@Document(collection = "category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    private ObjectId id;

    private Integer categoryId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private LanguageEntity lang;
}
