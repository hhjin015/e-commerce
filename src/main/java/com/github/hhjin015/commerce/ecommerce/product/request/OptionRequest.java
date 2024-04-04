package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionRequest {
    private String name;
    private List<String> values;
}
