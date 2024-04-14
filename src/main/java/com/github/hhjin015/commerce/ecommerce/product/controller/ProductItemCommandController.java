package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.parser.DtoToDataParser;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.DecreaseQuantityRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.ModifyProductItemRequest;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemCommandService;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ModifyProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductItemCommandController {

    private final ProductItemCommandService productItemCommandService;
    private final DtoToDataParser parser;

    @PatchMapping("/product-items/{id}/quantity")
    public ResponseEntity<String> decreaseQuantity(@PathVariable String id, @RequestBody DecreaseQuantityRequest request) {
        HttpStatus status;
        String message;

        try {
            productItemCommandService.decreaseQuantity(id, request.getDecreaseAmount());
            status = HttpStatus.OK;
            message = "재고가 정상 감소되었습니다.";
        } catch (Exception e) {
            e.printStackTrace();
            status = HttpStatus.BAD_REQUEST;
            message = "재고가 부족합니다.";
        }

        return new ResponseEntity<>(message, status);
    }

    @PatchMapping("/product-items")
    public ResponseEntity<Void> modifyProductItem(@RequestBody ModifyProductItemRequest request) {
        String op = request.getOperation();

        switch (op) {
            case "ADD" -> {
                List<ProductItemData> data = parser.parseProductItemDtoToData(request.getCreatePI());
                productItemCommandService.addProductItem(request.getProductId(), data);
            }
            case "REMOVE" -> {
                productItemCommandService.deleteProductItem(request.getRemoveIds());
            }
            case "MODIFY" -> {
                List<ModifyProductItemData> data = parser.parseModifyProductItemDtoToData(request.getModifyPI());
                productItemCommandService.modifyProductItem(data);
            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
