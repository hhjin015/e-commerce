package com.github.hhjin015.commerce.ecommerce.product.domain.product;

public interface ProductRepository {

    void save(Product product);

    Product findBy(ProductId id);
}
