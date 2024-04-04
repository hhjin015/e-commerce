package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductItem {
    private final ProductItemId productItemId;
    private final Product product;
    private int salePrice;
    private int quantity;
    private final OptionCombination optionCombination;
    private ProductSalesStatus salesStatus;

    public ProductItem(ProductItemId productItemId, Product product, int quantity, OptionCombination optionCombination) {
        this.productItemId = productItemId;
        this.product = product;
        this.quantity = quantity;
        this.optionCombination = optionCombination;
        this.salesStatus = ProductSalesStatus.PENDING;
        this.salePrice = calcSalePrice();
    }

    private int calcSalePrice() {
        if (this.optionCombination == null) return this.product.getPrice();
        else return this.optionCombination.getAdditionalPrice() + this.product.getPrice();
    }
}
