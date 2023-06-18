package kz.bidify.dictionaryservice.service;

import kz.bidify.dictionaryservice.model.entity.CityEntity;
import kz.bidify.dictionaryservice.model.entity.SubcategoryEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface SubcategoryService {

    SubcategoryEntity getOneBySubcategoryIdAndLang(Integer subcategoryId, String lang);

    List<SubcategoryEntity> getListByLang(String lang);

    List<SubcategoryEntity> getListByCategoryIdAndLang(Integer categoryId, String lang);
}
