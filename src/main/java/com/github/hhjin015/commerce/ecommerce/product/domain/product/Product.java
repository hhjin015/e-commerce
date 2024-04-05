package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import lombok.Getter;

import java.util.List;

@Getter
public class Product {
    private final ProductId id;
    private final String name;
    private final String description;
    private final int price;
    private final boolean optionUsable;
    private final List<Option> options;
    private final ProductSalesStatus salesStatus;

    public Product(ProductId id, String name, String description, int price, boolean optionUsable, List<Option> options) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.optionUsable = optionUsable;
        this.options = options;
        this.salesStatus = ProductSalesStatus.PENDING;
    }
}
