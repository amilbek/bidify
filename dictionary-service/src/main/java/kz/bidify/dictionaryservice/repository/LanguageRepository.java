package kz.bidify.dictionaryservice.repository;

import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends MongoRepository<LanguageEntity, ObjectId> {

    Optional<LanguageEntity> findByCode(String code);
}
