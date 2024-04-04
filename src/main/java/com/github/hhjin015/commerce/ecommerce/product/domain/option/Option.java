package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class Option {
    String name;
    List<String> values;
}
