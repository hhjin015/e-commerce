package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ModifyProductRequest {
    private String name;
    private String description;
    private int price;
    @JsonProperty("options")
    private List<OptionDto> optionsDto;
}
