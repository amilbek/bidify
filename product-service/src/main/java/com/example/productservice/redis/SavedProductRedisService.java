package com.example.productservice.redis;

import com.example.productservice.model.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public interface SavedProductRedisService {

    Map<UUID, ProductEntity> getSavedProducts();

    void addSavedProduct(UUID productId);

    void removeSavedProduct(UUID productId);
}
