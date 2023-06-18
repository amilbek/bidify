package kz.bidify.dictionaryservice.model.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CityDTO {

    private ObjectId id;
    private Integer cityId;
    private String name;
    private CountryDTO countryDTO;
    private LanguageDTO languageDTO;
}
