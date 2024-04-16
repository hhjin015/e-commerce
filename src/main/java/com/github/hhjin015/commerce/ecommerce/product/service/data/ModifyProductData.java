package com.github.hhjin015.commerce.ecommerce.product.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ModifyProductData {
    private String name;
    private String description;
    private int price;
    private List<OptionData> optionsData;
}
