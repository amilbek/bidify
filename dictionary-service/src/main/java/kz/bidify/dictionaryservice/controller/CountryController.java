package kz.bidify.dictionaryservice.controller;

import io.swagger.annotations.ApiOperation;
import kz.bidify.dictionaryservice.model.dto.CountryDTO;
import kz.bidify.dictionaryservice.service.CountryService;
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
@RequestMapping(Constants.SERVICE_NAME + Constants.API_PATH + Constants.COUNTRY_REST_ENDPOINT)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{lang}/{id}")
    @ApiOperation("Get Product By Category ID and Language")
    public ResponseEntity<CountryDTO> getOneByCategoryIdAndLang(@PathVariable("lang") String lang, @PathVariable("id") Integer countryId) {
        return ResponseEntity.ok(ModelMapperUtil.map(countryService.getOneByCountryIdAndLang(countryId, lang), CountryDTO.class));
    }

    @GetMapping("/{lang}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<CountryDTO>> getListByLang(@PathVariable("lang") String lang) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(countryService.getListByLang(lang), List.class)
        );
    }
}
