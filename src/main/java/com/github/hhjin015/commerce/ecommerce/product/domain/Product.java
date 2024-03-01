package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * 판매자가 생성하는 객체
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private int defaultPrice;
    private List<Option> options;
    private int quantity;
    private SalesStatus salesStatus;
}
