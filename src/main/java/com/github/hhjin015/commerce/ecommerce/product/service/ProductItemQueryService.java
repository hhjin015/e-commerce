package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductItemQueryService {

    private final ProductRepository productRepository;

    public ProductItem findProductItemBy(String id) {
        return productRepository.findProductItemBy(ProductItemId.of(id)).orElseThrow(
                () -> new NoSuchElementException("해당 상품 아이템이 존재하지 않습니다."));
    }
}
