package kz.bidify.dictionaryservice.service.impl;

import kz.bidify.dictionaryservice.model.entity.CountryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CountryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;
import kz.bidify.dictionaryservice.service.CountryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, LanguageRepository languageRepository) {
        this.countryRepository = countryRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public CountryEntity getOneByCountryIdAndLang(Integer countryId, String lang) {
        LanguageEntity languageEntity = getLanguageEntity(lang);
        return countryRepository.findByCountryIdAndLang(countryId, languageEntity)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with country ID " + countryId));
    }

    @Override
    public List<CountryEntity> getListByLang(String lang) {
        return countryRepository.findAll()
                .stream()
                .filter(country -> country.getLang().getCode().equals(lang))
                .toList();
    }

    private LanguageEntity getLanguageEntity(String code) {
        return languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
    }
}
