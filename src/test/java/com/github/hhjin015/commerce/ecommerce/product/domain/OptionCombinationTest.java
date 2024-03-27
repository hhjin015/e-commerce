package com.github.hhjin015.commerce.ecommerce.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OptionCombinationTest {

    public static final int PRICE = 1000;
    public static final List<String> OPTION_NAMES = List.of("S", "red");

    @Test
    @DisplayName("수량이 1개 이상일 때, 판매상태는 판매중이다.")
    void checkSalesStatusWithQuantity() {
        int quantity = 10;
        OptionCombination optionCombination = getOptionCombination(quantity);

        assertThat(optionCombination.getSalesStatus()).isEqualTo(SalesStatus.ON_SALE);
    }


    @Test
    @DisplayName("수량이 0개 일 때, 판매상태는 품절이다.")
    void checkSalesStatusWithNoQuantity() {
        int quantity = 0;
        OptionCombination optionCombination = getOptionCombination(quantity);

        assertThat(optionCombination.getSalesStatus()).isEqualTo(SalesStatus.SOLD_OUT);
    }

    private static OptionCombination getOptionCombination(int quantity) {
        return new OptionCombination(OPTION_NAMES, PRICE, quantity);
    }
}