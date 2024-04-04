package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductQueryService productQueryService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findBy(@PathVariable ProductId id) {
        Product product = productQueryService.findBy(id);

        return ResponseEntity.ok(product);
    }
}
