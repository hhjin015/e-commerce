package com.github.hhjin015.commerce.ecommerce.product.controller.response;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private int price;
    private List<Option> options;
    private ProductSalesStatus salesStatus;
}
