package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.Getter;

@Getter
public class ProductItem {
    private String productItemId;
    private Product product;
    private OptionCombination optionCombination;
    private int salePrice;

    public ProductItem(String productItemId, Product product, OptionCombination optionCombination) {
        this.productItemId = productItemId;
        this.product = product;
        this.optionCombination = optionCombination;

        this.salePrice = calcSalePrice();
    }

    private int calcSalePrice() {
        if(this.optionCombination == null) return this.product.getPrice();
        else return this.optionCombination.getPrice() + this.product.getPrice();
    }
}
