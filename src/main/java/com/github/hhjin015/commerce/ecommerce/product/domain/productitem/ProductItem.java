package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import static java.util.Objects.isNull;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class ProductItem {
    private final ProductItemId id;
    private int salePrice;
    private int quantity;
    private OptionCombination optionCombination;
    @Builder.Default
    private ProductItemSalesStatus salesStatus = ProductItemSalesStatus.ON_SALE;

    public void update(int quantity, OptionCombination optionCombination, int defaultPrice) {
        this.quantity = quantity;
        this.optionCombination = optionCombination;
        updateSalePrice(defaultPrice);
        changeSalesStatus();
    }

    public void updateSalePrice(int defaultPrice) {
        if (isNull(optionCombination)) salePrice = defaultPrice;
        else salePrice = optionCombination.getAdditionalPrice() + defaultPrice;
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
        if (this.quantity - amount < 0) throw new IllegalStateException("재고가 부족합니다.");
    }
}
