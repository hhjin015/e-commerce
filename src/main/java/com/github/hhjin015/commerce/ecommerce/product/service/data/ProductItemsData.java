package com.github.hhjin015.commerce.ecommerce.product.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductItemsData {
    private List<ProductItemData> productItemsData;
    private boolean optionUsable;
    private int defaultPrice;
}
