package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import org.springframework.stereotype.Component;

@Component
public class OptionCombinationInstantiation {

    public OptionCombination instantiate(String optionNames, int additionalPrice) {
        return OptionCombination.builder()
                .optionNames(optionNames)
                .additionalPrice(additionalPrice)
                .build();
    }
}
