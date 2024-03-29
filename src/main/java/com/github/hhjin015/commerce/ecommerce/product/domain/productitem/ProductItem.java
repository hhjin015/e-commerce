package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.SalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductItem {
    private final String productItemId;
    private final Product product;
    private int salePrice;
    private int quantity;
    private final OptionCombination optionCombination;
    private SalesStatus salesStatus;

    public ProductItem(String productItemId, Product product, int quantity, OptionCombination optionCombination) {
        this.productItemId = productItemId;
        this.product = product;
        this.salePrice = calcSalePrice();
        this.quantity = quantity;
        this.optionCombination = optionCombination;
        this.salesStatus = SalesStatus.PENDING;
    }

    private int calcSalePrice() {
        if (this.optionCombination == null) return this.product.getPrice();
        else return this.optionCombination.getAdditionalPrice() + this.product.getPrice();
    }
}
