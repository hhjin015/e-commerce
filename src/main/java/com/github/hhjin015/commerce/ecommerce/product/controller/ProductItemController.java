package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductItemController {

    private final ProductItemQueryService productItemQueryService;

    @GetMapping("/product-items/{id}")
    public ResponseEntity<List<ProductItem>> findAllBy(@PathVariable ProductId id) {
        List<ProductItem> productItems = productItemQueryService.findAllBy(id);

        return ResponseEntity.ok(productItems);
    }

    @GetMapping("/product-item/{id}")
    public ResponseEntity<ProductItem> findBy(@PathVariable ProductItemId id) {
        ProductItem productItem = productItemQueryService.findBy(id);

        return ResponseEntity.ok(productItem);
    }
}
