package com.example.productservice.redis.impl;

import com.example.productservice.model.entity.ProductEntity;
import com.example.productservice.model.entity.enums.ProductEvent;
import com.example.productservice.model.entity.enums.ProductStatus;
import com.example.productservice.redis.ProductRedisService;
import com.example.productservice.security.AuthenticationFacade;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class ProductRedisServiceImpl implements ProductRedisService {

    private static final String MY_PRODUCT_KEY = "MY_PRODUCTS: ";

    private final RedisTemplate<String, Object> redisTemplate;
    private final AuthenticationFacade authenticationFacade;

    private HashOperations<String, UUID, ProductEntity> hashOperations;

    @Autowired
    public ProductRedisServiceImpl(RedisTemplate<String, Object> redisTemplate, AuthenticationFacade authenticationFacade) {
        this.redisTemplate = redisTemplate;
        this.authenticationFacade = authenticationFacade;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<UUID, ProductEntity> getProducts() {
        String key = MY_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        return hashOperations.entries(key);
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        productEntity.setProductEvent(ProductEvent.CREATE);
        productEntity.setProductStatus(ProductStatus.ACTIVE);
        String key = MY_PRODUCT_KEY + productEntity.getUserId();
        hashOperations.put(key, productEntity.getProductId(), productEntity);
    }

    @Override
    public void editProduct(UUID productId, ProductEntity productEntity) {
        ProductEntity dbProductEntity = getProduct(productId);
        dbProductEntity.setProductName(productEntity.getProductName());
        dbProductEntity.setDescription(productEntity.getProductName());
        dbProductEntity.setPrice(productEntity.getPrice());
        dbProductEntity.setCategoryId(productEntity.getCategoryId());
        dbProductEntity.setSubcategoryId(productEntity.getSubcategoryId());
        dbProductEntity.setProductEvent(ProductEvent.EDIT);
        dbProductEntity.setProductStatus(ProductStatus.EDITED);

        String key = MY_PRODUCT_KEY + productEntity.getUserId();
        hashOperations.put(key, productEntity.getProductId(), dbProductEntity);
    }

    @Override
    public void archiveProduct(UUID productId) {
        ProductEntity productEntity = getProduct(productId);
        productEntity.setProductStatus(ProductStatus.INACTIVE);
        productEntity.setProductEvent(ProductEvent.ARCHIVE);
        String key = MY_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        hashOperations.put(key, productId, productEntity);
    }

    @Override
    public void deleteProduct(UUID productId) {
        String key = MY_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        hashOperations.delete(key, productId);
    }

    @Override
    public ProductEntity getProduct(UUID productId) {
        String key = MY_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        return hashOperations.get(key, productId);
    }
}
