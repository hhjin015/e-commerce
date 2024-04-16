package com.github.hhjin015.commerce.ecommerce.product.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyProductItemData {
    private String productItemId;
    private int quantity;
    private int additionalPrice;
}