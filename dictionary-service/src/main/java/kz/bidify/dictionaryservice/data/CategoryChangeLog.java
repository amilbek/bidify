package kz.bidify.dictionaryservice.data;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.CategoryEntity;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.CategoryRepository;
import kz.bidify.dictionaryservice.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class CategoryChangeLog {

    @ChangeSet(order = "004", id = "insertCategory", author = "Nurbolat")
    public void insertCategory(CategoryRepository categoryRepository, LanguageRepository languageRepository) {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        categoryEntityList.add(createNewCategory(1, "Сән", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(1, "Мода", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(1, "Fashion", "en", languageRepository));
        categoryEntityList.add(createNewCategory(2, "Электроника", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(2, "Электроника", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(2, "Electronics", "en", languageRepository));
        categoryEntityList.add(createNewCategory(3, "Үй және бақ", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(3, "Дом и Сад", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(3, "Home & Garden", "en", languageRepository));
        categoryEntityList.add(createNewCategory(4, "Коллекциялау және Өнер", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(4, "Коллекционирование и Искусство", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(4, "Collectibles & Art", "en", languageRepository));
        categoryEntityList.add(createNewCategory(5, "Спорттық тауарлар", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(5, "Спортивные товары", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(5, "Sporting Goods", "en", languageRepository));
        categoryEntityList.add(createNewCategory(6, "Ойыншықтар және Хобби", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(6, "Игрушки и Хобби", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(6, "Toys & Hobbies", "en", languageRepository));
        categoryEntityList.add(createNewCategory(7, "Бизнес және Өнеркәсіп", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(7, "Бизнес и Промышленность", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(7, "Business & Industrial", "en", languageRepository));
        categoryEntityList.add(createNewCategory(8, "Денсаулық және сұлулық", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(8, "Здоровье и Красота", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(8, "Health & Beauty", "en", languageRepository));
        categoryEntityList.add(createNewCategory(9, "Музыка", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(9, "Музыка", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(9, "Music", "en", languageRepository));
        categoryEntityList.add(createNewCategory(10, "Транспорт", "kz", languageRepository));
        categoryEntityList.add(createNewCategory(10, "Транспорт", "ru", languageRepository));
        categoryEntityList.add(createNewCategory(10, "Motors", "en", languageRepository));

        categoryRepository.insert(categoryEntityList);
    }

    private CategoryEntity createNewCategory(Integer categoryId, String name, String code, LanguageRepository languageRepository) {
        LanguageEntity language = languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
        return CategoryEntity
                .builder()
                .categoryId(categoryId)
                .name(name)
                .lang(language)
                .build();
    }
}
