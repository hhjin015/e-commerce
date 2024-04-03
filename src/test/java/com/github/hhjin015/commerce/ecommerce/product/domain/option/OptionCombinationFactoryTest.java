package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionCombinationData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OptionCombinationFactoryTest {

    OptionCombinationFactory optionCombinationFactory = new OptionCombinationFactory();

    @Test
    void createOptionCombination() {
        OptionCombinationData data = new OptionCombinationData(List.of("S,빨강"), 1000, 10);
        OptionCombination factoryBy = optionCombinationFactory.createBy(data);

        Assertions.assertThat(factoryBy).isNotNull();
    }

}