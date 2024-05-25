package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import org.springframework.stereotype.Component;

@Component
public class OptionFactory {

    public Option createBy(OptionData optionData) {
        return new Option(optionData.getName(), optionData.getValues());
    }
}
