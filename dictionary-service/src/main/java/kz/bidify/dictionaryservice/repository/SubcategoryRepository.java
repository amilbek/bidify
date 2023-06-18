package kz.bidify.dictionaryservice.repository;

import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.model.entity.SubcategoryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends MongoRepository<SubcategoryEntity, ObjectId> {

    Optional<SubcategoryEntity> findBySubcategoryIdAndLang(Integer subcategoryId, LanguageEntity languageEntity);
}
