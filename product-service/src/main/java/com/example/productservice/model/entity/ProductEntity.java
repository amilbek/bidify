package com.example.productservice.model.entity;

import com.example.productservice.model.entity.enums.ProductEvent;
import com.example.productservice.model.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Builder
@Document(collection = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    @Column(unique = true)
    private UUID productId;

    private String productName;

    private String description;

    private BigDecimal price;

    private Integer categoryId;

    private Integer subcategoryId;

    private UUID userId;

    private ProductEvent productEvent;

    private ProductStatus productStatus;
}
