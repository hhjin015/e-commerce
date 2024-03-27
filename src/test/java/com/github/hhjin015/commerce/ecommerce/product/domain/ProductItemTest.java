package com.github.hhjin015.commerce.ecommerce.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductItemTest {

    public static final int QUANTITY = 0;
    public static final List<String> OPTION_NAMES = List.of("S", "red");

    @Test
    @DisplayName("ProductItem에 OptionCombination이 있으면 가격이 추가된다.")
    void calcSalePriceWithOptionCombination() {
        new ProductItem(null ,null, null);
    }

    @Test
    @DisplayName("ProductItem에 OptionCombination이 없으면 가격이 추가되지 않는다.")
    void calcSalePriceWithNoOptionCombination() {

    }

    private static OptionCombination getOptionCombination(int price) {
        return new OptionCombination(OPTION_NAMES, price, QUANTITY);
    }
}
