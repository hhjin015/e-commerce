package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.request.DecreaseQuantityRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.request.ModifyProductItemRequest;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ResponseMessage;
import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class ProductItemCommandController {

    private final ProductItemCommandService productItemCommandService;

    @PatchMapping("/product-items/{id}/quantity")
    public ResponseEntity<ResponseMessage> decreaseQuantity(@PathVariable String id, @RequestBody DecreaseQuantityRequest request) {
        ResponseMessage responseMessage;

        try {
            productItemCommandService.decreaseQuantity(id, request.getDecreaseAmount());
            responseMessage = new ResponseMessage("정상 감소되었습니다.", HttpStatus.OK);

        } catch (IllegalStateException e) {
            e.printStackTrace();
            responseMessage = new ResponseMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(responseMessage, responseMessage.getStatus());
    }

    @PatchMapping("/product-items")
    public ResponseEntity<ResponseMessage> modifyProductItem(@Valid @RequestBody ModifyProductItemRequest request) {
        String op = request.getOperation();
        ResponseMessage responseMessage;

        try {
            switch (op) {
                case "ADD" -> {
                    productItemCommandService.addProductItem(request.getProductId(), request.productItemDtoToData());
                    responseMessage = new ResponseMessage("추가되었습니다.", HttpStatus.OK);
                }
                case "REMOVE" -> {
                    productItemCommandService.deleteProductItem(request.getRemoveIds());
                    responseMessage = new ResponseMessage("삭제되었습니다.", HttpStatus.OK);
                }
                case "MODIFY" -> {
                    productItemCommandService.modifyProductItem(request.modifyProductItemDtoToData());
                    responseMessage = new ResponseMessage("수정되었습니다.", HttpStatus.OK);
                }
                default -> responseMessage = new ResponseMessage("올바르지 않은 작업입니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            responseMessage = new ResponseMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseMessage, responseMessage.getStatus());
    }
}
