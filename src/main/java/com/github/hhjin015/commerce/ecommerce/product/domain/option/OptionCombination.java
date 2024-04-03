package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OptionCombination {
    private final List<String> optionNames;
    private final int additionalPrice;
}
