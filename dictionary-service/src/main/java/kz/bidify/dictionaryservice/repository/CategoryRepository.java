package kz.bidify.dictionaryservice.repository;

import kz.bidify.dictionaryservice.model.entity.CategoryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryEntity, ObjectId> {

    Optional<CategoryEntity> findByCategoryIdAndLang(Integer categoryId, LanguageEntity languageEntity);
}
