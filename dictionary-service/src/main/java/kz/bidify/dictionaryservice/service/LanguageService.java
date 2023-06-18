package kz.bidify.dictionaryservice.service;

import kz.bidify.dictionaryservice.model.entity.LanguageEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {

    LanguageEntity getOneByCode(String code);

    List<LanguageEntity> getLanguageList();
}
