package kz.bidify.dictionaryservice.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SubcategoryDTO {

    private ObjectId id;
    private Integer subcategoryId;
    private String name;
    private CategoryDTO categoryDTO;
    private LanguageDTO languageDTO;
}
