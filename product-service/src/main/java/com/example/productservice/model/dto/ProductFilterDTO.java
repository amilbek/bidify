package com.example.productservice.model.dto;

import lombok.Data;

@Data
public class ProductFilterDTO {

    private String productName;
    private String description;
    private Integer categoryId;
    private Integer subcategoryId;
}
