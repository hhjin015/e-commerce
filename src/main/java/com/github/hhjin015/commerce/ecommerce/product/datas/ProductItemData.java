package com.github.hhjin015.commerce.ecommerce.product.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * quantity: optionUsable이 false면 그대로 사용, true면 optionCombinationData의 optionQuantity 사용
 */
@Getter
@AllArgsConstructor
public class ProductItemData {
    private int quantity;
    private OptionCombinationData optionCombinationData;
}
