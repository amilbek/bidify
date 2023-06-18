package com.example.productservice.redis;

import com.example.productservice.model.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public interface ProductRedisService {

    Map<UUID, ProductEntity> getProducts();

    void addProduct(ProductEntity productEntity);

    void editProduct(UUID productId, ProductEntity productEntity);

    void archiveProduct(UUID productId);

    void deleteProduct(UUID productId);

    ProductEntity getProduct(UUID productId);
}
