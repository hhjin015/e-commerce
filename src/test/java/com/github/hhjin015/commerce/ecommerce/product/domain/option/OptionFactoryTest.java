package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OptionFactoryTest {

    OptionFactory sut = new OptionFactory();

    @Test
    void createOption() {
        Option actual = sut.createBy(new OptionData("사이즈", List.of("S, M, L")));
        Assertions.assertThat(actual).isNotNull();
    }
}