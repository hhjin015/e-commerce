package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemResponse;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemsResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductItemQueryController {

    private final ProductItemQueryService productItemQueryService;

    @GetMapping("/product-items")
    public ResponseEntity<ProductItemsResponse> findAllBy(@RequestParam("productId") String productId) {
        List<ProductItem> productItems = productItemQueryService.findAllBy(productId);

        ProductItemsResponse productItemsResponse = getProductItemsResponse(productItems);

        return new ResponseEntity<>(productItemsResponse, HttpStatus.OK);
    }


    @GetMapping("/product-items/{id}")
    public ResponseEntity<ProductItem> findBy(@PathVariable String id) {
        ProductItem productItem = productItemQueryService.findBy(id);

        return new ResponseEntity<>(productItem, HttpStatus.OK);
    }

    private static ProductItemsResponse getProductItemsResponse(List<ProductItem> productItems) {
        List<ProductItemResponse> productItemResponses = new ArrayList<>();
        for (ProductItem productItem : productItems) {
            productItemResponses.add(
                    new ProductItemResponse(
                            productItem.getProductItemId().getValue(),
                            productItem.getSalePrice(),
                            productItem.getQuantity(),
                            productItem.getOptionCombination(),
                            productItem.getSalesStatus()
                    )
            );
        }

        return new ProductItemsResponse(productItems.get(0).getProduct(), productItemResponses);
    }
}
