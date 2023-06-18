package kz.bidify.dictionaryservice.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CategoryDTO {

    private ObjectId id;
    private Integer categoryId;
    private String name;
    private LanguageDTO languageDTO;
}
