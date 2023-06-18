package com.example.productservice.redis.impl;

import com.example.productservice.model.entity.ProductEntity;
import com.example.productservice.redis.SavedProductRedisService;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.security.AuthenticationFacade;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class SavedProductRedisServiceImpl implements SavedProductRedisService {

    private static final String SAVED_PRODUCT_KEY = "SAVED_PRODUCTS: ";

    private final RedisTemplate<String, Object> redisTemplate;
    private final AuthenticationFacade authenticationFacade;
    private final ProductRepository productRepository;

    private HashOperations<String, UUID, ProductEntity> hashOperations;

    public SavedProductRedisServiceImpl(RedisTemplate<String, Object> redisTemplate, AuthenticationFacade authenticationFacade, ProductRepository productRepository) {
        this.redisTemplate = redisTemplate;
        this.authenticationFacade = authenticationFacade;
        this.productRepository = productRepository;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<UUID, ProductEntity> getSavedProducts() {
        String key = SAVED_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        return hashOperations.entries(key);
    }

    @Override
    public void addSavedProduct(UUID productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID " + productId));
        String key = SAVED_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        hashOperations.put(key, productEntity.getProductId(), productEntity);
    }

    @Override
    public void removeSavedProduct(UUID productId) {
        String key = SAVED_PRODUCT_KEY + authenticationFacade.getUser().getUserId();
        hashOperations.delete(key, productId);
    }
}
