package com.github.hhjin015.commerce.ecommerce.product.domain;

import java.util.List;

public interface ProductItemRepository {

    List<Product> findAll();

    void save(Product productItem);
}
