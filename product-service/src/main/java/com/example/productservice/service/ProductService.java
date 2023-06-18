package com.example.productservice.service;

import com.example.productservice.model.dto.ProductFilterDTO;
import com.example.productservice.model.entity.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(UUID productId);

    ProductEntity editProduct(UUID productId, ProductEntity productEntity);

    ProductEntity archiveProduct(UUID productId);

    ProductEntity banProduct(UUID productId);

    void deleteProduct(UUID productId);

    List<ProductEntity> getProductList();
}
