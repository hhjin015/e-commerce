package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import org.springframework.stereotype.Component;

@Component
public class OptionCombinationFactory {

    public OptionCombination createBy(OptionCombinationData optionCombinationData) {
        return new OptionCombination(optionCombinationData.getOptionNames(), optionCombinationData.getAdditionalPrice());
    }
}
