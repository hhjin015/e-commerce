package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductItemResponse;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> findBy(@PathVariable String id) {
        try {
            Product product = productQueryService.findBy(id);
            ProductResponse productResponse = getProductResponse(product);

            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private static List<ProductItemResponse> getProductItemsResponse(Product p) {
        List<ProductItemResponse> productItemResponseList = new ArrayList<>();

        for (ProductItem pi : p.getProductItems()) {
            productItemResponseList.add(
                    new ProductItemResponse(
                            pi.getId().getValue(),
                            pi.getSalePrice(),
                            pi.getQuantity(),
                            pi.getOptionCombination(),
                            pi.getSalesStatus()
                    ));
        }
        return productItemResponseList;
    }

    private static ProductResponse getProductResponse(Product p) {
        return new ProductResponse(
                p.getId().getValue(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getOptions(),
                p.getSalesStatus(),
                getProductItemsResponse(p)
        );
    }
}
