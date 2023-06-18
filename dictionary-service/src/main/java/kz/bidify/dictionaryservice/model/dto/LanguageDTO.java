package kz.bidify.dictionaryservice.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class LanguageDTO {

    private ObjectId id;
    private String name;
    private String code;
}
