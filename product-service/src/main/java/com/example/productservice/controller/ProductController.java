package com.example.productservice.controller;

import com.example.productservice.model.dto.ProductCreateDTO;
import com.example.productservice.model.dto.ProductDTO;
import com.example.productservice.model.dto.ProductEditDTO;
import com.example.productservice.model.entity.ProductEntity;
import com.example.productservice.redis.ProductRedisService;
import com.example.productservice.redis.SavedProductRedisService;
import com.example.productservice.service.ProductService;
import com.example.productservice.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRedisService productRedisService;
    private final SavedProductRedisService savedProductRedisService;

    @Autowired
    public ProductController(ProductService productService, ProductRedisService productRedisService, SavedProductRedisService savedProductRedisService) {
        this.productService = productService;
        this.productRedisService = productRedisService;
        this.savedProductRedisService = savedProductRedisService;
    }

    /** GET PRODUCT FROM DATABASE */
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable("productId") UUID productId) {
        return ModelMapperUtil.map(productService.getProduct(productId), ProductDTO.class);
    }

    /** GET ALL PRODUCT LIST */
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        return productService.getProductList()
                .stream()
                .map(productEntity -> ModelMapperUtil.map(productEntity, ProductDTO.class))
                .toList();
    }

    /** SAVE PRODUCT IN DATABASE AND IN CACHE */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        ProductEntity productEntity = productService.saveProduct(ModelMapperUtil.map(productCreateDTO, ProductEntity.class));
        productRedisService.addProduct(productEntity);
        return ModelMapperUtil.map(productEntity, ProductDTO.class);
    }

    /** EDIT PRODUCT IN DATABASE AND IN CACHE */
    @PutMapping("/my-products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO editProduct(@PathVariable("productId") UUID productId, ProductEditDTO productEditDTO) {
        ProductEntity productEntity = productService.editProduct(productId, ModelMapperUtil.map(productEditDTO, ProductEntity.class));
        productRedisService.editProduct(productId, productEntity);
        return ModelMapperUtil.map(productEntity, ProductDTO.class);
    }

    /** ARCHIVE PRODUCT IN DATABASE AND IN CACHE */
    @PutMapping("/my-products/archive/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO archiveProduct(@PathVariable("productId") UUID productId) {
        productRedisService.archiveProduct(productId);
        return ModelMapperUtil.map(productService.archiveProduct(productId), ProductDTO.class);
    }

    /** DELETE PRODUCT FROM CACHE AND CHANGE STATUS IN DATABASE */
    @DeleteMapping("/my-products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        productService.deleteProduct(productId);
        productRedisService.deleteProduct(productId);
    }

    @GetMapping("/my-products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getMyProduct(@PathVariable("productId") UUID productId) {
        return ModelMapperUtil.map(productRedisService.getProduct(productId), ProductDTO.class);
    }

    @GetMapping("/my-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getMyProducts() {
        return productRedisService.getProducts().values()
                .stream()
                .map(productEntity -> ModelMapperUtil.map(productEntity, ProductDTO.class))
                .toList();
    }

    /** ADD SAVED PRODUCT IN CACHE */
    @PostMapping("/save-product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void addSavedProduct(@PathVariable("productId") UUID productId) {
        savedProductRedisService.addSavedProduct(productId);
    }

    /** REMOVE SAVED PRODUCT FROM CACHE */
    @PostMapping("/remove-product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeSavedProduct(@PathVariable("productId") UUID productId) {
        savedProductRedisService.removeSavedProduct(productId);
    }

    @GetMapping("/saved-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getSavedProducts() {
        return savedProductRedisService.getSavedProducts().values()
                .stream()
                .map(productEntity -> ModelMapperUtil.map(productEntity, ProductDTO.class))
                .toList();
    }
}
