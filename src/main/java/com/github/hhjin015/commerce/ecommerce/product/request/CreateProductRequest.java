package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreateProductRequest {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private boolean optionUsable;
//    private OptionInfo optionInfo;
    private List<CreateOptionRequest> optionRequests;
    private List<CreateOptionCombinationRequest> optionCombinationRequests;
}
