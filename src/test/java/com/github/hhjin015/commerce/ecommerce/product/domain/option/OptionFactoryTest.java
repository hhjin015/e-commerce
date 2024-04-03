package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OptionFactoryTest {

    OptionFactory optionFactory = new OptionFactory();

    @Test
    void createOption() {
        OptionData data = new OptionData("사이즈", List.of("S, M, L"));

        Option factoryBy = optionFactory.createBy(data);
        Assertions.assertThat(factoryBy).isNotNull();
    }
}