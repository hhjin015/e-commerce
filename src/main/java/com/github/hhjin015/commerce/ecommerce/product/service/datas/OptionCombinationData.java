package com.github.hhjin015.commerce.ecommerce.product.service.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionCombinationData {
    private List<String> optionNames;
    private int additionalPrice;
    private int optionCombQuantity;
}
