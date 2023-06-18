package kz.bidify.dictionaryservice.controller;

import io.swagger.annotations.ApiOperation;
import kz.bidify.dictionaryservice.model.dto.CategoryDTO;
import kz.bidify.dictionaryservice.service.CategoryService;
import kz.bidify.dictionaryservice.util.Constants;
import kz.bidify.dictionaryservice.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.SERVICE_NAME + Constants.API_PATH + Constants.CATEGORY_REST_ENDPOINT)
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{lang}/{id}")
    @ApiOperation("Get Product By Category ID and Language")
    public ResponseEntity<CategoryDTO> getOneByCategoryIdAndLang(@PathVariable("lang") String lang, @PathVariable("id") Integer categoryId) {
        return ResponseEntity.ok(ModelMapperUtil.map(categoryService.getOneByCategoryIdAndLang(categoryId, lang), CategoryDTO.class));
    }

    @GetMapping("/{lang}")
    @ApiOperation("Get List by Language")
    public ResponseEntity<List<CategoryDTO>> getListByLang(@PathVariable("lang") String lang) {
        return ResponseEntity.ok(
                ModelMapperUtil.map(categoryService.getListByLang(lang), List.class)
        );
    }
}
