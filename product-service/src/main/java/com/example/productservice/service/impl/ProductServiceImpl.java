package com.example.productservice.service.impl;

import com.example.productservice.model.entity.ProductEntity;
import com.example.productservice.model.entity.enums.ProductEvent;
import com.example.productservice.model.entity.enums.ProductStatus;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.security.AuthenticationFacade;
import com.example.productservice.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AuthenticationFacade authenticationFacade) {
        this.productRepository = productRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        UUID userId = UUID.fromString(authenticationFacade.getUser().getUserId());
        productEntity.setUserId(userId);
        productEntity.setProductEvent(ProductEvent.CREATE);
        productEntity.setProductStatus(ProductStatus.ACTIVE);
        productEntity.setProductId(UUID.randomUUID());
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getProduct(UUID productId) {
        return productRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID " + productId));
    }

    @Override
    public ProductEntity editProduct(UUID productId, ProductEntity productEntity) {
        ProductEntity dbProductEntity = getProduct(productId);
        dbProductEntity.setProductName(productEntity.getProductName());
        dbProductEntity.setDescription(productEntity.getProductName());
        dbProductEntity.setPrice(productEntity.getPrice());
        dbProductEntity.setCategoryId(productEntity.getCategoryId());
        dbProductEntity.setSubcategoryId(productEntity.getSubcategoryId());
        dbProductEntity.setProductEvent(ProductEvent.EDIT);
        dbProductEntity.setProductStatus(ProductStatus.EDITED);
        return productRepository.save(dbProductEntity);
    }

    @Override
    public ProductEntity archiveProduct(UUID productId) {
        ProductEntity productEntity = getProduct(productId);
        productEntity.setProductEvent(ProductEvent.ARCHIVE);
        productEntity.setProductStatus(ProductStatus.INACTIVE);
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity banProduct(UUID productId) {
        ProductEntity productEntity = getProduct(productId);
        productEntity.setProductEvent(ProductEvent.BAN);
        productEntity.setProductStatus(ProductStatus.INACTIVE);
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(UUID productId) {
        ProductEntity productEntity = getProduct(productId);
        productEntity.setProductEvent(ProductEvent.DELETE);
        productEntity.setProductStatus(ProductStatus.DELETED);
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getProductList() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProductStatus().equals(ProductStatus.ACTIVE) &&
                        productEntity.getProductStatus().equals(ProductStatus.EDITED))
                .toList();
    }
}
