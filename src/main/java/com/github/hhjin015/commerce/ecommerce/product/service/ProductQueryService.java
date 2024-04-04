package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductRepository productRepository;

    public Product findBy(ProductId productId) {
        return productRepository.findBy(productId);
    }
}
