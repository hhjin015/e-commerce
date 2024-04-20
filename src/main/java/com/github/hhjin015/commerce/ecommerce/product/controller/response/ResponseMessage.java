package com.github.hhjin015.commerce.ecommerce.product.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ResponseMessage {
    private String message;
    private HttpStatus status;
}
