package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class ProductItemQueryController {

    private final ProductItemQueryService productItemQueryService;

    @GetMapping("/product-items/{id}")
    public ResponseEntity<ProductItemResponse> findBy(@PathVariable String id) {
        try {
            ProductItem productItem = productItemQueryService.findProductItemBy(id);
            ProductItemResponse productItemResponse = getProductItemResponse(productItem);
            return ResponseEntity.ok(productItemResponse);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private static ProductItemResponse getProductItemResponse(ProductItem pi) {
        return new ProductItemResponse(
                pi.getProductItemId().getValue(),
                pi.getSalePrice(),
                pi.getQuantity(),
                pi.getOptionCombination(),
                pi.getSalesStatus()
        );
    }
}
