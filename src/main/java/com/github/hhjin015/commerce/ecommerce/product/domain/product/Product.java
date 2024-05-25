package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class Product {
    private ProductId id;
    private String name;
    private String description;
    private int price;
    private List<Option> options;
    private final List<ProductItem> productItems;
    @Builder.Default
    private ProductSalesStatus salesStatus = ProductSalesStatus.PENDING;

    public void update(String name, String description, int price, List<Option> options, ProductSalesStatus status) {
        this.name = name;
        this.description = description;
        updatePrice(price);
        this.options = options;
        this.salesStatus = status;
    }

    public void removeProductItem(ProductItemId id) {
        this.productItems.removeIf(pi -> id.equals(pi.getId()));
    }

    public void addProductItems(List<ProductItem> productItems) {
        this.productItems.addAll(productItems);
    }

    public Optional<ProductItem> getProductItem(ProductItemId id) {
        for (ProductItem productItem : productItems) {
            if(productItem.getId().equals(id)) return Optional.of(productItem);
        }
        return Optional.empty();
    }

    private void updatePrice(int price) {
        this.price = price;
        for (ProductItem pi : productItems) {
            pi.updateSalePrice(price);
        }
    }
}
