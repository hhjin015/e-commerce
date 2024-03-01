package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 구매자가 생성하는 객체
 */
@Getter
@AllArgsConstructor
public class ProductItem {
    private int productItemId;
    private Product product;
    private List<Option> options;
    private int totalPrice;
    private int quantity;
    private SalesStatus salesStatus;

    public ProductItem(int productItemId, Product product, List<Option> options, int quantity) {
        this.productItemId = productItemId;
        this.product = product;
        this.options = options;
        this.quantity = quantity;

        this.totalPrice = calcTotalPrice();
    }

    private int calcTotalPrice() {
        int price = 0;
        for (Option option : options) {
            price += option.getAdditionalAmount();
        }

        return price + product.getDefaultPrice();
    }

    public void changeQuantity(int provided) {

        if (this.quantity - provided < 0) {
            throw new IllegalArgumentException("갯수는 0개 이하일 수 없어요");
        }

        this.quantity -= provided;
    }
}
