package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductItemQueryController {

    private final ProductItemQueryService productItemQueryService;

    @GetMapping("/product-items")
    public ResponseEntity<List<ProductItem>> findAllBy(@RequestParam("productId") String productId) {
        List<ProductItem> productItems = productItemQueryService.findAllBy(productId);

        return ResponseEntity.ok(productItems);
    }

    @GetMapping("/product-items/{id}")
    public ResponseEntity<ProductItem> findBy(@PathVariable String id) {
        ProductItem productItem = productItemQueryService.findBy(id);

        return ResponseEntity.ok(productItem);
    }
}
