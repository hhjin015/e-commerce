package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;

import java.util.List;

public interface ProductItemRepository {

    void save(ProductItem productItem);

    List<ProductItem> findAllBy(ProductId productId);

    ProductItem findBy(ProductItemId id);
}
