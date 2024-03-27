package com.github.hhjin015.commerce.ecommerce.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateProductItemTest {

    public static final int ANY_ID = 1;
    public static final int ANY_QUANTITY = 10;

    public ProductItem sut;

    @Test
    @DisplayName("productItem 이 생성되었을 때 totalPrice 가 결정된다")
    void buy() {
        /*sut = new ProductItem(
                ANY_ID,
                anyProductOf(1000),
                List.of(anyOptionOf(500), anyOptionOf(1000)),
                ANY_QUANTITY);

        assertThat(sut.getTotalPrice()).isEqualTo(1000 + 500 + 1000);*/
    }

    private static Option anyOptionOf(int additionalAmount) {
        /*return new Option("사이즈", "S", additionalAmount);*/
        return null;
    }

    private static Product anyProductOf(int price) {
        /*return new Product(1, "테디베어 양말", "양말입니다.", price);*/
        return null;
    }
}
