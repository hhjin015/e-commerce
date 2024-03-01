package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Option {
    private String name;
    private String value;
    private int additionalAmount;
}
