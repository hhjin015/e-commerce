package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;

import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findBy(ProductId id);

    Optional<ProductItem> findProductItemBy(ProductItemId id);
}
