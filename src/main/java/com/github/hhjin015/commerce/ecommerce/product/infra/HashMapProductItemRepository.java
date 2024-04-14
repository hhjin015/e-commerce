package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HashMapProductItemRepository implements ProductItemRepository {

    private final Map<ProductItemId, ProductItem> storage = new HashMap<>();

    @Override
    public void save(ProductItem productItem) {
        storage.put(productItem.getProductItemId(), productItem);
    }

    @Override
    public void deleteBy(ProductItemId id) {
        storage.remove(id);
    }

    @Override
    public List<ProductItem> findAllBy(ProductId productId) {
        List<ProductItem> productItems = new ArrayList<>();

        for (ProductItemId key : storage.keySet()) {
            ProductItem productItem = storage.get(key);

            if (productItem.getProduct().getId().equals(productId)) {
                productItems.add(productItem);
            }
        }

        return productItems;
    }

    @Override
    public ProductItem findBy(ProductItemId id) {
        return storage.get(id);
    }
}
