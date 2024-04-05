package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemQueryService {

    private final ProductItemRepository productItemRepository;

    public List<ProductItem> findAllBy(String id) {
        return productItemRepository.findAllBy(ProductId.of(id));
    }

    public ProductItem findBy(String id) {
        return productItemRepository.findBy(ProductItemId.of(id));
    }
}
