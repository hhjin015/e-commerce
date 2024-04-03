package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionCombinationData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OptionCombinationFactoryTest {

    OptionCombinationFactory sut = new OptionCombinationFactory();

    @Test
    void createOptionCombination() {
        OptionCombinationData data = new OptionCombinationData(List.of("S,빨강"), 1000, 10);
        OptionCombination actual = sut.createBy(data);

        Assertions.assertThat(actual).isNotNull();
    }

}