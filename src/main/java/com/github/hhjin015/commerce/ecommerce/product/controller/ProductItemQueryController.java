package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemResponse;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemsResponse;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
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
        ProductResponse productResponse = getProductResponse(productItems.get(0).getProduct());
        ProductItemsResponse productItemsResponse = getProductItemsResponse(productResponse, productItems);

        return new ResponseEntity<>(productItemsResponse, HttpStatus.OK);
    }


    @GetMapping("/product-items/{id}")
    public ResponseEntity<ProductItemResponse> findBy(@PathVariable String id) {
        ProductItem productItem = productItemQueryService.findBy(id);
        ProductItemResponse productItemResponse = getProductItemResponse(productItem);

        return new ResponseEntity<>(productItemResponse, HttpStatus.OK);
    }

    private static ProductItemsResponse getProductItemsResponse(ProductResponse productResponse, List<ProductItem> productItems) {
        List<ProductItemResponse> productItemResponses = new ArrayList<>();
        for (ProductItem pi : productItems) {
            productItemResponses.add(
                    new ProductItemResponse(
                            pi.getProductItemId().getValue(),
                            pi.getSalePrice(),
                            pi.getQuantity(),
                            pi.getOptionCombination(),
                            pi.getSalesStatus()
                    )
            );
        }

        return new ProductItemsResponse(productResponse, productItemResponses);
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
