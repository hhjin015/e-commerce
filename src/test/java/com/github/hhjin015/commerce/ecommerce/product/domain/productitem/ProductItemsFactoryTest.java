package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.support.AbstractFactoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductItemsFactoryTest extends AbstractFactoryTest {

    ProductItemsFactory sut = new ProductItemsFactory(new OptionCombinationFactory());

    @Test
    @DisplayName("옵션 있는 상품 아이템 생성")
    void createProductItemWithOption() {
        List<ProductItem> actual = sut.createBy(PRODUCT_ITEMS_DATA_WITH_OPTION);
        assertThat(actual).isNotNull();
        assertThat(actual.get(0).getOptionCombination()).isNotNull();
    }

    @Test
    @DisplayName("옵션 없는 상품 아이템 생성")
    void createProductItemWithoutOption() {
        List<ProductItem> actual = sut.createBy(PRODUCT_ITEMS_DATA_WITHOUT_OPTION);
        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0).getOptionCombination()).isNull();
    }

    @Test
    @DisplayName("옵션이 있을 경우, 상품 아이템의 가격은 기본가 + 옵션가 이다.")
    void checkPriceWithOption() {
        List<ProductItem> list = sut.createBy(PRODUCT_ITEMS_DATA_WITH_OPTION);
        for (ProductItem actual : list) {
            assertThat(actual.getSalePrice()).isEqualTo(DEFAULT_PRICE + ADDITIONAL_PRICE);
        }
    }

    @Test
    @DisplayName("옵션이 없을 경우, 상품 아이템의 가격은 기본가 이다.")
    void checkPriceWithoutOption() {
        List<ProductItem> actual = sut.createBy(PRODUCT_ITEMS_DATA_WITHOUT_OPTION);
        assertThat(actual.get(0).getSalePrice()).isEqualTo(DEFAULT_PRICE);
    }
}