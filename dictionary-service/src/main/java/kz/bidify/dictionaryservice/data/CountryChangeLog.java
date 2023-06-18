package kz.bidify.dictionaryservice.data;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.CategoryEntity;
import kz.bidify.dictionaryservice.model.entity.CountryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CountryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class CountryChangeLog {

    @ChangeSet(order = "002", id = "insertCountry", author = "Nurbolat")
    public void insertCountry(CountryRepository countryRepository, LanguageRepository languageRepository) {
        List<CountryEntity> countryEntityList = new ArrayList<>();
        countryEntityList.add(createNewCountry(1, "Қазақстан", "kz", languageRepository));
        countryEntityList.add(createNewCountry(1, "Казахстан", "ru", languageRepository));
        countryEntityList.add(createNewCountry(1, "Kazakhstan", "en", languageRepository));
        countryEntityList.add(createNewCountry(2, "Ресей", "kz", languageRepository));
        countryEntityList.add(createNewCountry(2, "Россия", "ru", languageRepository));
        countryEntityList.add(createNewCountry(2, "Russian", "en", languageRepository));

        countryRepository.insert(countryEntityList);
    }

    private CountryEntity createNewCountry(Integer countryId, String name, String code, LanguageRepository languageRepository) {
        LanguageEntity language = languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
        return CountryEntity
                .builder()
                .countryId(countryId)
                .name(name)
                .lang(language)
                .build();
    }
}
