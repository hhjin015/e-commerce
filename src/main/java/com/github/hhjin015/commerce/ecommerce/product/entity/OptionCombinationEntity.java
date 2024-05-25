package com.github.hhjin015.commerce.ecommerce.product.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class OptionCombinationEntity {
    private String name;
    private String value;

    public static OptionCombinationEntity toEntity(String optionName, String optionValue) {
        return new OptionCombinationEntity(optionName, optionValue);
    }
}
