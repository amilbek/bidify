package kz.bidify.dictionaryservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.CityEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CityRepository;
import kz.bidify.dictionaryservice.repository.CountryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;
import kz.bidify.dictionaryservice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository,
                           LanguageRepository languageRepository) {
        this.cityRepository = cityRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public CityEntity getOneByCityIdAndLang(Integer cityId, String lang) {
        LanguageEntity language = getLanguageEntity(lang);
        return cityRepository.findByCityIdAndLang(cityId, language)
                .orElseThrow(() -> new EntityNotFoundException("City not found with city ID " + cityId));
    }

    @Override
    public List<CityEntity> getListByLang(String lang) {
        return cityRepository.findAll()
                .stream()
                .filter(city -> city.getLang().getCode().equals(lang))
                .toList();
    }

    @Override
    public List<CityEntity> getListByCountryIdAndLang(Integer countryId, String lang) {
        return cityRepository.findAll()
                .stream()
                .filter(city -> Objects.equals(city.getCountry().getCountryId(), countryId) &&
                        city.getCountry().getLang().getCode().equals(lang))
                .toList();
    }

    private LanguageEntity getLanguageEntity(String code) {
        return languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
    }
}
