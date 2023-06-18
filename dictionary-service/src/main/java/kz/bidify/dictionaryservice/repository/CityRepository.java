package kz.bidify.dictionaryservice.repository;

import kz.bidify.dictionaryservice.model.entity.CityEntity;
import kz.bidify.dictionaryservice.model.entity.CountryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends MongoRepository<CityEntity, ObjectId> {

    Optional<CityEntity> findByCityIdAndLang(Integer cityId, LanguageEntity lang);
}
