package kz.bidify.dictionaryservice.service;

import kz.bidify.dictionaryservice.model.entity.CityEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    CityEntity getOneByCityIdAndLang(Integer cityId, String lang);

    List<CityEntity> getListByLang(String lang);

    List<CityEntity> getListByCountryIdAndLang(Integer countryId, String lang);
}
