package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.request.DecreaseQuantityRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.ModifyProductItemRequest;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemCommandService;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductQueryService;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductItemData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class ProductItemCommandController {

    private final ProductQueryService productQueryService;
    private final ProductItemCommandService productItemCommandService;

    @PatchMapping("/product-items")
    public ResponseEntity<String> modifyProductItem(@RequestParam("productId") String productId, @Valid @RequestBody ModifyProductItemRequest request) {
        try {
            Product product = productQueryService.findBy(productId);
            ModifyProductItemData modifyData = request.toData(product);
            productItemCommandService.modifyProductItem(modifyData);

            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/product-items/{id}/quantity")
    public ResponseEntity<String> decreaseQuantity(@PathVariable String id, @Valid @RequestBody DecreaseQuantityRequest request) {
        try {
            productItemCommandService.decreaseQuantity(id, request.getDecreaseAmount());
            return ResponseEntity.ok().body("정상 감소되었습니다.");
        } catch (IllegalStateException | NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
