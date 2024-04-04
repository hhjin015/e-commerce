package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionCombinationRequest {
    private List<String> optionNames;
    private int additionalPrice;
    private int optionCombQuantity;
}
