package com.example.productservice.specification;

import com.example.productservice.model.dto.ProductFilterDTO;
import com.example.productservice.model.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class ProductSpecification  {

    private final ProductFilterDTO productFilterDTO;

    public ProductSpecification(ProductFilterDTO productFilterDTO) {
        this.productFilterDTO = productFilterDTO;
    }


    public Predicate toPredicate(Root<ProductEntity> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (nonNull(productFilterDTO.getProductName())) {
            predicates.add(criteriaBuilder.like(root.get("productName"), productFilterDTO.getProductName()));
        }
        if (nonNull(productFilterDTO.getDescription())) {
            predicates.add(criteriaBuilder.like(root.get("description"), productFilterDTO.getDescription()));
        }
        if (nonNull(productFilterDTO.getCategoryId())) {
            predicates.add(criteriaBuilder.equal(root.get("categoryId"), productFilterDTO.getCategoryId()));
        }
        if (nonNull(productFilterDTO.getSubcategoryId())) {
            predicates.add(criteriaBuilder.equal(root.get("subcategoryId"), productFilterDTO.getSubcategoryId()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }
}
