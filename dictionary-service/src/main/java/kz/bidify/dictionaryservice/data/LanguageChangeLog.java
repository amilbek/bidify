package kz.bidify.dictionaryservice.data;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import kz.bidify.dictionaryservice.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class LanguageChangeLog {

    @ChangeSet(order = "001", id = "insertLanguage", author = "Nurbolat")
    public void insertLanguage(LanguageRepository languageRepository) {
        List<LanguageEntity> languageEntityList = new ArrayList<>();
        languageEntityList.add(createNewLanguage("Kazakh", "kz"));
        languageEntityList.add(createNewLanguage("Russian", "ru"));
        languageEntityList.add(createNewLanguage("English", "en"));

        languageRepository.insert(languageEntityList);
    }

    private LanguageEntity createNewLanguage(String name, String code) {
        return LanguageEntity
                .builder()
                .name(name)
                .code(code)
                .build();
    }
}
