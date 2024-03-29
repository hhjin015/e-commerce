package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Option {
    private String name;
    private List<String> values;
}
