package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;

import java.util.List;

public interface ProductItemRepository {

    List<Product> findAll();

    void save(Product productItem);
}
