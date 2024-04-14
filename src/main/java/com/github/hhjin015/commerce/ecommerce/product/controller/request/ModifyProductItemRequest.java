package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ModifyProductItemRequest {
    private String operation;
    private List<String> removeIds;
    private String productId;
    private List<ProductItemDto> createPI;
    private List<ModifyProductItemDto> modifyPI;
}
