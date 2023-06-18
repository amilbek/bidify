package kz.bidify.dictionaryservice.controller;

import io.swagger.annotations.ApiOperation;
import kz.bidify.dictionaryservice.model.dto.SubcategoryDTO;
import kz.bidify.dictionaryservice.service.SubcategoryService;
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
@RequestMapping(Constants.SERVICE_NAME + Constants.API_PATH + Constants.SUBCATEGORY_REST_ENDPOINT)
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/{lang}/{id}")
    @ApiOperation("Get Product By Category ID and Language")
    public ResponseEntity<SubcategoryDTO> getOneByCategoryIdAndLang(@PathVariable("lang") String lang, @PathVariable("id") Integer subcategoryId) {
        return ResponseEntity.ok(ModelMapperUtil.map(subcategoryService.getOneBySubcategoryIdAndLang(subcategoryId, lang), SubcategoryDTO.class));
    }

    @GetMapping("/{lang}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<SubcategoryDTO>> getListByLang(@PathVariable("lang") String lang) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(subcategoryService.getListByLang(lang), List.class)
        );
    }

    @GetMapping("/{lang}/category/{categoryId}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<SubcategoryDTO>> getListByCountryIdAndLang(@PathVariable("lang") String lang, @PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(subcategoryService.getListByCategoryIdAndLang(categoryId, lang), List.class)
        );
    }
}
