package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.parser.DtoToDataParser;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.ModifyProductRequest;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductCommandService;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;
    private final DtoToDataParser parser;

    @PatchMapping("/products/{id}")
    public ResponseEntity<Void> modifyProduct(@PathVariable String id, @RequestBody ModifyProductRequest request) {
        productCommandService.modifyProduct(id, parseUpdateProductRequestToDto(request));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ProductData parseUpdateProductRequestToDto(ModifyProductRequest request) {
        return new ProductData(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                parser.parseOptionDtoToData(request.getOptionsDto())
        );
    }
}
