package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> findBy(@PathVariable String id) {
        Product p = productQueryService.findBy(id);
        ProductResponse productResponse = getProductResponse(p);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    private static ProductResponse getProductResponse(Product p) {
        return new ProductResponse(
                p.getId().getValue(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getOptions(),
                p.getSalesStatus()
        );
    }
}
