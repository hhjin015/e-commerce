package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;

public class OptionFactory {

    public Option createBy(OptionData optionData) {
        return Option.of(optionData.getName(), optionData.getValues());
    }
}
