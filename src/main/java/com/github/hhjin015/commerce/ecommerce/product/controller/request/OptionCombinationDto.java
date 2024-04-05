package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionCombinationDto {
    private List<String> optionNames;
    private int additionalPrice;
    private int optionCombQuantity;
}
