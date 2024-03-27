package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private boolean optionUsable;
    private OptionInfo optionInfo;
    private SalesStatus salesStatus;

    public Product(String id, String name, String description, int price, int quantity, boolean optionUsable, OptionInfo optionInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.optionUsable = optionUsable;
        this.optionInfo = optionInfo;
        this.salesStatus = SalesStatus.PENDING;
    }
}
