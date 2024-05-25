package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OptionCombinationDto {
    private String optionNames;
    private int additionalPrice;

    public OptionCombinationData toData() {
        return new OptionCombinationData(optionNames, additionalPrice);
    }
}
