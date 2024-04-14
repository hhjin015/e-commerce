package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.event.Events;
import com.github.hhjin015.commerce.ecommerce.product.event.ProductPriceChangedEvent;
import lombok.Getter;

import java.util.List;

@Getter
public class Product {
    private final ProductId id;
    private String name;
    private String description;
    private int price;
    private List<Option> options;
    private final ProductSalesStatus salesStatus;

    public Product(ProductId id, String name, String description, int price, List<Option> options) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.options = options;
        this.salesStatus = ProductSalesStatus.PENDING;
    }

    public void update(String name, String description, int price, List<Option> options) {
        this.name = name;
        this.description = description;
        updatePrice(price);
        this.options = options;
    }

    private void updatePrice(int price) {
        this.price = price;
        Events.raise(new ProductPriceChangedEvent(this.id));
    }
}
