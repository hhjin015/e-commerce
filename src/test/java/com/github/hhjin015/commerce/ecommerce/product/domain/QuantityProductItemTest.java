//package com.github.hhjin015.commerce.ecommerce.product.domain;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class QuantityProductItemTest {
//
//    public static final int ANY_ID = 1;
//    public static final Product ANY_PRODUCT = new Product(1, "테디베어 양말", "양말입니다.", 1000);
//    public static final List<Option> ANY_OPTION = List.of(anyOptionOf(500), anyOptionOf(1000));
//
//    public ProductItem sut;
//
//    @Test
//    void changeQuantity() {
//        sut = new ProductItem(
//                ANY_ID,
//                ANY_PRODUCT,
//                ANY_OPTION,
//                10);
//
//        sut.changeQuantity(4);
//
//        assertThat(sut.getQuantity()).isEqualTo(6);
//    }
//
//    @Test
//    void 갯수는_0개_이하일_수_없다() {
//        sut = new ProductItem(
//                ANY_ID,
//                ANY_PRODUCT,
//                ANY_OPTION,
//                10);
//
//        assertThatThrownBy(() -> sut.changeQuantity(1000))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    private static Option anyOptionOf(int additionalAmount) {
//        return new Option("사이즈", "S", additionalAmount);
//    }
//
//}
