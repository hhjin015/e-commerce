package com.github.hhjin015.commerce.ecommerce.product.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OptionData {
    private String name;
    private List<String> values;
}
