package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.request.CreateProductRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductIdResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.service.CreateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductService createProductService;

    @PostMapping("/products")
    public ResponseEntity<ProductIdResponse> createProduct(@RequestBody CreateProductRequest request) {
        ProductId productId = createProductService.create(request.getProductDto().toData(), request.toData());

        return new ResponseEntity<>(ProductIdResponse.of(productId.getValue()), HttpStatus.CREATED);
    }
}
