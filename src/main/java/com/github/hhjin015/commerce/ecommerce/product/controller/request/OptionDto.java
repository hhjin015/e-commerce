package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionDto {
    private String name;
    private List<String> values;
}
