package kz.bidify.dictionaryservice.data;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import jakarta.persistence.EntityNotFoundException;
import kz.bidify.dictionaryservice.model.entity.*;
import kz.bidify.dictionaryservice.repository.*;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class SubcategoryChangeLog {

    @ChangeSet(order = "005", id = "insertSubcategory", author = "Nurbolat")
    public void insertSubcategory(SubcategoryRepository subcategoryRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository) {
        List<SubcategoryEntity> subcategoryEntityList = new ArrayList<>();

        subcategoryEntityList.add(createNewSubcategory(1, "Әйелдер киімі", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(1, "Женская одежда", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(1, "Women's Clothing", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(2, "Ерлер киімі", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(2, "Мужская одежда", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(2, "Men's Clothing", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(3, "Аяқ киім", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(3, "Обувь", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(3, "Shoes", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(4, "Аксессуарлар", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(4, "Аксессуары", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(4, "Accessories", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(5, "Зергерлік бұйымдар", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(5, "Ювелирные изделия", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(5, "Jewelry", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(6, "Сағаттар", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(6, "Часы", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(6, "Watches", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(7, "Сөмкелер", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(7, "Сумки", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(7, "Handbags", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(8, "Күннен қорғайтын көзілдірік", "kz", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(8, "Солнцезащитные очки", "ru", 1, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(8, "Sunglasses", "en", 1, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(9, "Компьютерлер мен планшеттер", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(9, "Компьютеры и планшеты", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(9, "Computers & Tablets", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(10, "Телефондар мен Аксессуарлары", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(10, "Телефоны и аксессуары", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(10, "Cell Phones & Accessories", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(11, "Фотоаппараттар мен Фототехника", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(11, "Камеры и фото", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(11, "Cameras & Photo", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(12, "Телевизорлар, Видео және Үй аудио", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(12, "ТВ, видео и аудио", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(12, "TV, Video & Home Audio", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(13, "Видео ойындары және приставкалар", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(13, "Видеоигры и приставки", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(13, "Video Games & Consoles", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(14, "Автомобильдік электроника", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(14, "Автомобильная электроника", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(14, "Car Electronics", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(15, "Ақылды үй", "kz", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(15, "Умный дом", "ru", 2, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(15, "Smart Home", "en", 2, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(16, "Үй декоры", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(16, "Декор для дома", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(16, "Home Décor", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(17, "Төсек-орын", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(17, "Постельное белье", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(17, "Bedding", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(18, "Жуынатын бөлмеге арналған өнімдер", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(18, "Товары для ванных комнат", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(18, "Bath", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(19, "Ас үйге арналған ыдыс - аяқ пен тауарлар", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(19, "Посуда и товары для кухни", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(19, "Kitchen, Dining & Bar", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(20, "Шеберханаға арналған құралдар мен жабдықтар", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(20, "Инструменты и оборудование для мастерской", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(20, "Tools & Workshop Equipment", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(21, "Үлкен Тұрмыстық техника", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(21, "Большие бытовые приборы", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(21, "Major Appliances", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(22, "Жиһаз", "kz", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(22, "Мебель", "ru", 3, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(22, "Furniture", "en", 3, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(23, "Монеты и банкноты", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(23, "Coins & Paper Money", "en", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(23, "Монеты и банкноты", "ru", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(24, "Маркалар", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(24, "Марки", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(24, "Stamps", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(25, "Антиквариат", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(25, "Антиквариат", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(25, "Antiques", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(26, "Кескіндеме және графика", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(26, "Живопись и графика", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(26, "Art", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(27, "Спорттық кәдесыйлар", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(27, "Спортивные сувениры", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(27, "Sports Memorabilia", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(28, "Музыкалы кәдесыйлар", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(28, "Музыкальные сувениры", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(28, "Music Memorabilia", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(29, "Кино-кәдесыйлар", "kz", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(29, "Кино-сувениры", "ru", 4, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(29, "Movie Memorabilia", "en", 4, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(30, "Outdoor Sports", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(30, "Аулалық спорт", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(30, "Спорт на открытом воздухе", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(31, "Team Sports", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(31, "Топтық ойындар", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(31, "Командные виды спорта", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(32, "Fitness, Running & Yoga", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(32, "Фитнес, жүгіру, йога", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(32, "Фитнес, бег и йога", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(33, "Golf", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(33, "Гольф", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(33, "Гольф", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(34, "Hunting", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(34, "Аңшылық", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(34, "Охота", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(35, "Fishing", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(35, "Балық аулау", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(35, "Рыбалка", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(36, "Cycling", "en", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(36, "Велосипед", "kz", 5, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(36, "Велосипеды", "ru", 5, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(37, "Ойыншық фигуралары", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(37, "Игрушечные фигурки", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(37, "Action Figures", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(38, "Қуыршақтар мен аюлар", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(38, "Куклы и мишки", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(38, "Dolls & Bears", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(39, "Ойындар", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(39, "Игры", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(39, "Games", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(40, "Модельдік пойыздар", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(40, "Модельные поезда", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(40, "Model Trains", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(41, "RC автомобильдерінің модельдері мен жиынтықтары", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(41, "Модели и комплекты RC-автомобилей", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(41, "RC Model Vehicles & Kits", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(42, "Шығармашылық", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(42, "Творчество", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(42, "Crafts", "en", 6, languageRepository, categoryRepository));

        subcategoryEntityList.add(createNewSubcategory(43, "Басқатырғыштар", "kz", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(43, "Пазлы", "ru", 6, languageRepository, categoryRepository));
        subcategoryEntityList.add(createNewSubcategory(43, "Puzzles", "en", 6, languageRepository, categoryRepository));

        subcategoryRepository.insert(subcategoryEntityList);
    }

    private SubcategoryEntity createNewSubcategory(Integer subcategoryId,
                                     String name,
                                     String code,
                                     Integer categoryId,
                                     LanguageRepository languageRepository,
                                     CategoryRepository categoryRepository) {
        LanguageEntity language = languageRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Language not found with code " + code));
        CategoryEntity category = categoryRepository.findByCategoryIdAndLang(categoryId, language)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID " + categoryId + " and language " + language.getName()));
        return SubcategoryEntity
                .builder()
                .subcategoryId(subcategoryId)
                .name(name)
                .lang(language)
                .category(category)
                .build();
    }
}
