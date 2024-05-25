package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductRepository productRepository;

    public Product findBy(String id) {
        return productRepository.findBy(ProductId.of(id)).orElseThrow(
                () -> new NoSuchElementException("해당 상품이 존재하지 않습니다."));
    }
}
