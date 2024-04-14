package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public class ProductItem {
    private final ProductItemId productItemId;
    private final Product product;
    private int salePrice;
    private int quantity;
    private final OptionCombination optionCombination;
    private ProductItemSalesStatus salesStatus;

    public ProductItem(ProductItemId productItemId, Product product, int quantity, OptionCombination optionCombination) {
        this.productItemId = productItemId;
        this.product = product;
        this.quantity = quantity;
        this.optionCombination = optionCombination;
        this.salesStatus = ProductItemSalesStatus.ON_SALE;
        updateSalePrice();
    }

    public void updateQuantity(int amount) {
        this.quantity = amount;
    }

    public void updateSalePrice() {
        if (isNull(this.optionCombination)) this.salePrice = this.product.getPrice();
        else this.salePrice = this.optionCombination.getAdditionalPrice() + this.product.getPrice();
    }

    public void decreaseQuantity(int amount) {
        checkQuantity(amount);
        this.quantity -= amount;
    }

    private void checkQuantity(int amount) {
        if (this.quantity - amount < 0) throw new IllegalStateException("재고 부족");
        else if (this.quantity - amount == 0) changeSalesStatusSoldOut();
    }

    private void changeSalesStatusSoldOut() {
        this.salesStatus = ProductItemSalesStatus.SOLD_OUT;
    }
}
