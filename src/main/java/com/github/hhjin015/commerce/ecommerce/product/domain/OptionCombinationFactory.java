package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionCombinationRequest;

public class OptionCombinationFactory {

    public OptionCombination createBy(CreateOptionCombinationRequest optionCombinationRequest) {
        return new OptionCombination(optionCombinationRequest.getOptionNames(), optionCombinationRequest.getPrice(),optionCombinationRequest.getQuantity());
    }
}
