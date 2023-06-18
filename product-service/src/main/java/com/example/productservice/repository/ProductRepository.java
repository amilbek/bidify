package com.example.productservice.repository;

import com.example.productservice.model.entity.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, ObjectId>{

    Optional<ProductEntity> findByProductId(UUID productId);
}
