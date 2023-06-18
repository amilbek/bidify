package kz.bidify.dictionaryservice.service;

import kz.bidify.dictionaryservice.model.entity.CategoryEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryEntity getOneByCategoryIdAndLang(Integer categoryId, String lang);

    List<CategoryEntity> getListByLang(String lang);
}
