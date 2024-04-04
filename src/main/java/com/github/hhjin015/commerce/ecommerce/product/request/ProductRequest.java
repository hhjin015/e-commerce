package com.github.hhjin015.commerce.ecommerce.product.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private int price;
    private boolean optionUsable;
    private List<OptionRequest> optionRequests;
}
