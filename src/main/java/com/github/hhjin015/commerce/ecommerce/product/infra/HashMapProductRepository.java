package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Repository
public class HashMapProductRepository implements ProductRepository {

    private final Map<ProductId, Product> storage = new HashMap<>();

    @Override
    public ProductId save(Product product) {
        storage.put(product.getId(), product);
        return product.getId();
    }

    @Override
    public Optional<Product> findBy(ProductId id) {
        if (nonNull(storage.get(id))) return Optional.of(storage.get(id));
        return Optional.empty();
    }

    public Optional<ProductItem> findProductItemBy(ProductItemId id) {
        for (Product product : storage.values()) {
            for (ProductItem pi : product.getProductItems()) {
                if (pi.getId().equals(id)) {
                    return Optional.of(pi);
                }
            }
        }
        return Optional.empty();
    }
}
