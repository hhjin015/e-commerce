package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Option {
    private int optionId;
    private OptionName optionName;
    private OptionValue optionValue;
    private int additionalAmount;
}
