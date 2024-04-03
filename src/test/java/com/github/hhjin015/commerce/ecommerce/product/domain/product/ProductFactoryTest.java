package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductFactoryTest {

    ProductFactory sut = new ProductFactory(new OptionFactory());

    @Test
    @DisplayName("ProductData의 optionUsable이 false면 Product의 Option은 생성되지 않는다.")
    void createProductWithoutOption() {
        ProductData dataWithoutOptionData = getProductData(false, null);
        Product actual = sut.createBy(dataWithoutOptionData);

        assertThat(actual).isNotNull();
        assertThat(actual.getOptions()).isNull();
    }

    @Test
    @DisplayName("ProductData의 optionUsable이 true면 Product의 Option이 생성된다.")
    void createProductWithOption() {
        ProductData dataWithOptionData = getProductData(true, getOptionData());
        Product actual = sut.createBy(dataWithOptionData);

        assertThat(actual).isNotNull();
        assertThat(actual.getOptions().size()).isEqualTo(2);
    }

    private static List<OptionData> getOptionData() {
        return List.of(
                new OptionData("size", List.of("s, m")),
                new OptionData("color", List.of("red", "blue"))
        );
    }

    private static ProductData getProductData(boolean optionUsable, List<OptionData> optionData) {
        return new ProductData("양말", "양말 사세요", 1000, optionUsable, optionData);
    }
}