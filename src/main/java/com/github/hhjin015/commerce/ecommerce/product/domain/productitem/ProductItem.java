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
    private OptionCombination optionCombination;
    private ProductItemSalesStatus salesStatus;

    public ProductItem(ProductItemId productItemId, Product product, int quantity, OptionCombination optionCombination) {
        this.productItemId = productItemId;
        this.product = product;
        this.quantity = quantity;
        this.optionCombination = optionCombination;
        this.salesStatus = ProductItemSalesStatus.ON_SALE;
        updateSalePrice();
    }

    public void update(int quantity, int additionalPrice) {
        this.quantity = quantity;
        optionCombination = OptionCombination.of(optionCombination.getOptionNames(), additionalPrice);
        changeSalesStatus();
        updateSalePrice();
    }

    public void updateSalePrice() {
        if (isNull(optionCombination)) salePrice = product.getPrice();
        else salePrice = optionCombination.getAdditionalPrice() + product.getPrice();
    }

    public void decreaseQuantity(int amount) {
        checkQuantity(amount);
        quantity -= amount;
        changeSalesStatus();
    }

    private void changeSalesStatus() {
        if (this.quantity == 0) this.salesStatus = ProductItemSalesStatus.SOLD_OUT;
        else this.salesStatus = ProductItemSalesStatus.ON_SALE;
    }

    private void checkQuantity(int amount) {
        if (this.quantity - amount < 0) throw new IllegalStateException("재고 부족");
    }
}
