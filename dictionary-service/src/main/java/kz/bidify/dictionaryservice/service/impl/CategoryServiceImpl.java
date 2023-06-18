package kz.bidify.dictionaryservice.service.impl;

import kz.bidify.dictionaryservice.model.entity.CategoryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CategoryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;
import kz.bidify.dictionaryservice.service.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, LanguageRepository languageRepository) {
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public CategoryEntity getOneByCategoryIdAndLang(Integer categoryId, String lang) {
        LanguageEntity languageEntity = getLanguageEntity(lang);
        return categoryRepository.findByCategoryIdAndLang(categoryId, languageEntity)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with category ID " + categoryId));
    }

    @Override
    public List<CategoryEntity> getListByLang(String lang) {
        return categoryRepository.findAll()
                .stream()
                .filter(category -> category.getLang().getCode().equals(lang))
                .toList();
    }

    private LanguageEntity getLanguageEntity(String code) {
        return languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
    }
}
