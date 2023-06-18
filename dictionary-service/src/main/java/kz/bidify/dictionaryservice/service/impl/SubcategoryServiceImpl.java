package kz.bidify.dictionaryservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.model.entity.SubcategoryEntity;
import kz.bidify.dictionaryservice.repository.LanguageRepository;
import kz.bidify.dictionaryservice.repository.SubcategoryRepository;
import kz.bidify.dictionaryservice.service.SubcategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final LanguageRepository languageRepository;

    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository,
                                  LanguageRepository languageRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public SubcategoryEntity getOneBySubcategoryIdAndLang(Integer subcategoryId, String lang) {
        LanguageEntity language = getLanguageEntity(lang);
        return subcategoryRepository.findBySubcategoryIdAndLang(subcategoryId, language)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with city ID " + subcategoryId));
    }

    @Override
    public List<SubcategoryEntity> getListByLang(String lang) {
        return subcategoryRepository.findAll()
                .stream()
                .filter(city -> city.getLang().getCode().equals(lang))
                .toList();
    }

    @Override
    public List<SubcategoryEntity> getListByCategoryIdAndLang(Integer categoryId, String lang) {
        return subcategoryRepository.findAll()
                .stream()
                .filter(subcategory -> Objects.equals(subcategory.getCategory().getCategoryId(), categoryId) &&
                        subcategory.getCategory().getLang().getCode().equals(lang))
                .toList();
    }

    private LanguageEntity getLanguageEntity(String code) {
        return languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
    }
}
