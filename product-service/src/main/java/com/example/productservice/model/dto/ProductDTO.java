package com.example.productservice.model.dto;

import com.example.productservice.model.entity.enums.ProductEvent;
import com.example.productservice.model.entity.enums.ProductStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO {

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
