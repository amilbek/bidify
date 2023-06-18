package kz.bidify.dictionaryservice.controller;

import io.swagger.annotations.ApiOperation;
import kz.bidify.dictionaryservice.model.dto.CityDTO;
import kz.bidify.dictionaryservice.service.CityService;
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
@RequestMapping(Constants.SERVICE_NAME + Constants.API_PATH + Constants.CITY_REST_ENDPOINT)
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{lang}/{id}")
    @ApiOperation("Get Product By Category ID and Language")
    public ResponseEntity<CityDTO> getOneByCategoryIdAndLang(@PathVariable("lang") String lang, @PathVariable("id") Integer cityId) {
        return ResponseEntity.ok(ModelMapperUtil.map(cityService.getOneByCityIdAndLang(cityId, lang), CityDTO.class));
    }

    @GetMapping("/{lang}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<CityDTO>> getListByLang(@PathVariable("lang") String lang) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(cityService.getListByLang(lang), List.class)
        );
    }

    @GetMapping("/{lang}/country/{countryId}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<CityDTO>> getListByCountryIdAndLang(@PathVariable("lang") String lang, @PathVariable("countryId") Integer countryId) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(cityService.getListByCountryIdAndLang(countryId, lang), List.class)
        );
    }
}
