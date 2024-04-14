package com.github.hhjin015.commerce.ecommerce.product.service.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OptionCombinationData {
    private List<String> optionNames;
    private int additionalPrice;
}
