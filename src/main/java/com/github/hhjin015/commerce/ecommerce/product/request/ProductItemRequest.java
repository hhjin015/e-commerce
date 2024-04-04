package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductItemRequest {
    private int quantity;
    private OptionCombinationRequest optionCombinationRequest;
}
