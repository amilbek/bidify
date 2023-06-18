package kz.bidify.dictionaryservice.service;

import kz.bidify.dictionaryservice.model.entity.CountryEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    CountryEntity getOneByCountryIdAndLang(Integer countryId, String lang);

    List<CountryEntity> getListByLang(String lang);
}
