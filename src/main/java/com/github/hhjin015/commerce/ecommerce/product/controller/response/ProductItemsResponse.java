package com.github.hhjin015.commerce.ecommerce.product.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductItemsResponse {
    private ProductResponse product;
    private List<ProductItemResponse> productItems;
}
