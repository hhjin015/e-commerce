package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;

/**
 * 구매자가 생성하는 객체
 */
@AllArgsConstructor
public class ProductItem {
    private int productItemId;
    private Product product;
    private int totalPrice;
    private int quantity;
//    private SalesStatus salesStatus;


    public ProductItem(int productItemId, Product product) {
        this.productItemId = productItemId;
        this.product = product;

        setTotalPrice();
    }

    private int getAdditionalAmount() {
        int price = 0;
        for(Option option : this.product.getOptions()) {
            price += option.getAdditionalAmount();
        }

        return price;
    }

    public void setTotalPrice() {
        this.totalPrice = this.product.getDefaultPrice() + getAdditionalAmount();
    }
}
