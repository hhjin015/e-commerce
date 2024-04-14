package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;

import java.util.List;

public interface ProductItemRepository {

    void save(ProductItem productItem);

    void deleteBy(ProductItemId id);

    List<ProductItem> findAllBy(ProductId id);

    ProductItem findBy(ProductItemId id);
}
