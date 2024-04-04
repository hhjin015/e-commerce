package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetProductItemController {

    private final ProductItemRepository repository;

//    @GetMapping("/productItems")
//    public ResponseEntity<List<Product>> getAll() {
//        return ResponseEntity.ok(repository.findAll());
//    }
}
