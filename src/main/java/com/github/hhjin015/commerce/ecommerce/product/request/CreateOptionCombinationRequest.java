package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOptionCombinationRequest {
    private List<String> optionNames;
    private int price;
    private int quantity;
}
