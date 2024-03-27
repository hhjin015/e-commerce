package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    private String name;
    private List<String> values;
}