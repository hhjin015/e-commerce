package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.parser.DtoToDataParser;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.CreateProductRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductIdResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.service.CreateProductService;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductService createProductService;
    private final DtoToDataParser parser;

    @PostMapping("/products")
    public ResponseEntity<ProductIdResponse> createProduct(@RequestBody CreateProductRequest request) {
        ProductData productData = parser.parseProductDtoToData(request.getProductDto());
        List<ProductItemData> productItemData = parser.parseProductItemDtoToData(request.getProductItemsDto());

        ProductId productId = createProductService.create(productData, productItemData);

        return new ResponseEntity<>(ProductIdResponse.of(productId.getValue()), HttpStatus.CREATED);
    }
}
