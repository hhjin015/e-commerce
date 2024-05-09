package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Getter
@NoArgsConstructor
public class CreateProductItemDto {
    private int quantity;

    @JsonProperty("optionCombination")
    private OptionCombinationDto optionCombinationDto;

    public ProductItemData toData() {
        if(isNull(optionCombinationDto)) {
            return new ProductItemData(quantity, null);
        }
        return new ProductItemData(quantity, optionCombinationDto.toData());
    }
}
