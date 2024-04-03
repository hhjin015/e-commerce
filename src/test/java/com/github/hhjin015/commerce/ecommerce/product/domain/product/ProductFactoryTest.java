package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductFactoryTest {

    public ProductFactory productFactory;


    @BeforeEach
    void init() {
        OptionFactory optionFactory = new OptionFactory();
        productFactory = new ProductFactory(optionFactory);
    }

    @Test
    void createProductWithoutOption() {
        ProductData dataWithoutOptionData = getProductData(false, null);
        Product factoryBy = productFactory.createBy(dataWithoutOptionData);

        assertThat(factoryBy).isNotNull();
        assertThat(factoryBy.getOptions()).isNull();
    }

    @Test
    void createProductWithOption() {
        ProductData dataWithOptionData = getProductData(true, getOptionData());
        Product factoryBy = productFactory.createBy(dataWithOptionData);

        assertThat(factoryBy).isNotNull();
        assertThat(factoryBy.getOptions().size()).isEqualTo(2);
    }

    private static List<OptionData> getOptionData() {
        return List.of(
                new OptionData("size", List.of("s, m")),
                new OptionData("color", List.of("red", "blue"))
        );
    }

    private static ProductData getProductData(boolean optionUsable, List<OptionData> optionData) {
        return new ProductData(
                "양말",
                "양말 사세요",
                1000,
                optionUsable,
                optionData
        );
    }


}