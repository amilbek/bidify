package kz.bidify.dictionaryservice.controller;

import io.swagger.annotations.ApiOperation;
import kz.bidify.dictionaryservice.model.dto.LanguageDTO;
import kz.bidify.dictionaryservice.service.LanguageService;
import kz.bidify.dictionaryservice.util.Constants;
import kz.bidify.dictionaryservice.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.SERVICE_NAME + Constants.API_PATH + Constants.LANGUAGE_REST_ENDPOINT)
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/{code}")
    @ApiOperation("Get Language by code")
    public ResponseEntity<LanguageDTO> getOneByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(ModelMapperUtil.map(languageService.getOneByCode(code), LanguageDTO.class));
    }

    @GetMapping("/list")
    @ApiOperation("Get Language List")
    public ResponseEntity<List<LanguageDTO>> getList() {
        return ResponseEntity.ok(
                ModelMapperUtil.map(languageService.getLanguageList(), List.class)
        );
    }
}
