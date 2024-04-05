package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductItemDto {
    private int quantity;

    @JsonProperty("optionCombination")
    private OptionCombinationDto optionCombinationDto;
}
