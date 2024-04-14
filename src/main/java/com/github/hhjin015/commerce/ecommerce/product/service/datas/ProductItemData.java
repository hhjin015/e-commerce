package com.github.hhjin015.commerce.ecommerce.product.service.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductItemData {
    private int quantity;
    private OptionCombinationData optionCombinationData;
}
