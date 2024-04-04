package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionCombinationData;

public class OptionCombinationFactory {

    public OptionCombination createBy(OptionCombinationData optionCombinationData) {
        return OptionCombination.of(optionCombinationData.getOptionNames(), optionCombinationData.getAdditionalPrice());
    }
}
