package com.github.hhjin015.commerce.ecommerce.product.controller.response;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductItemResponse {
    private String id;
    private int salePrice;
    private int quantity;
    private OptionCombination optionCombination;
    private ProductItemSalesStatus salesStatus;
}
