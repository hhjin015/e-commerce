package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyProductItemDto {
    private String productItemId;
    private int quantity;
}
