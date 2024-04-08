package com.github.hhjin015.commerce.ecommerce.product.controller.response;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductItemsResponse {
    private Product product;
    private List<ProductItemResponse> productItems;
}
