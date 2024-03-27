package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionRequest;

public class OptionFactory {

    public Option createBy(CreateOptionRequest optionRequest) {
        return new Option(optionRequest.getName(), optionRequest.getValues());
    }
}
