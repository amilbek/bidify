package kz.bidify.dictionaryservice.data;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.CityEntity;
import kz.bidify.dictionaryservice.model.entity.CountryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CityRepository;
import kz.bidify.dictionaryservice.repository.CountryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class CityChangeLog {

    @ChangeSet(order = "003", id = "insertCity v2.1", author = "Nurbolat")
    public void insertCity(CityRepository cityRepository, LanguageRepository languageRepository, CountryRepository countryRepository) {
        List<CityEntity> cityEntityList = new ArrayList<>();
        cityEntityList.add(createNewCity(1, "Астана", "kz", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(1, "Астана", "ru", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(1, "Astana", "en", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(2, "Алматы", "kz", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(2, "Алматы", "ru", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(2, "Almaty", "en", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(3, "Тараз", "kz", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(3, "Тараз", "ru", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(3, "Taraz", "en", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(4, "Шымкент", "kz", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(4, "Шымкент", "ru", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(4, "Shymkent", "en", 1, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(5, "Мәскеу", "kz", 2, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(5, "Москва", "ru", 2, languageRepository, countryRepository));
        cityEntityList.add(createNewCity(5, "Moscow", "en", 2, languageRepository, countryRepository));

        cityRepository.insert(cityEntityList);
    }

    private CityEntity createNewCity(Integer cityId,
                                        String name,
                                        String code,
                                        Integer countryId,
                                        LanguageRepository languageRepository,
                                        CountryRepository countryRepository) {
        LanguageEntity language = languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
        CountryEntity country = countryRepository.findByCountryIdAndLang(countryId, language)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID " + countryId + " and language " + language.getName()));
        return CityEntity
                .builder()
                .cityId(cityId)
                .name(name)
                .lang(language)
                .country(country)
                .build();
    }
}
