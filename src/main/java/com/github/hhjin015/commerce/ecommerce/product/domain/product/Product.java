package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import lombok.Getter;

import java.util.List;

@Getter
public class Product {
    private final ProductId id;
    private String name;
    private String description;
    private int price;
    private boolean optionUsable;
    private List<Option> options;
    private ProductSalesStatus salesStatus;

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
