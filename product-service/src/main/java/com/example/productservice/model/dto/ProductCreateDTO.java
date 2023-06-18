package com.example.productservice.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateDTO {

    private String productName;

    private String description;

    private BigDecimal price;

    private Integer categoryId;

    private Integer subcategoryId;
}
