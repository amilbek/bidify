package kz.bidify.dictionaryservice.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CountryDTO {

    private ObjectId id;
    private Integer countryId;
    private String name;
    private LanguageDTO langDTO;
}
