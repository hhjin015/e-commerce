package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOptionRequest {
    private String name;
    private List<String> values;
}
