package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HashMapProductRepository implements ProductRepository {

    private final Map<ProductId, Product> storage = new HashMap<>();

    @Override
    public void save(Product product) {
        storage.put(product.getId(), product);
    }

    @Override
    public Product findBy(ProductId id) {
        return storage.get(id);
    }
}
