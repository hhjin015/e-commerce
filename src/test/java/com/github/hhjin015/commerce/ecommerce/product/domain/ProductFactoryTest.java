package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionCombinationRequest;
import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionRequest;
import com.github.hhjin015.commerce.ecommerce.product.request.CreateProductRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductFactoryTest {

    OptionFactory optionFactory = new OptionFactory();
    OptionCombinationFactory optionCombinationFactory = new OptionCombinationFactory();
    OptionInfoFactory optionInfoFactory = new OptionInfoFactory(optionFactory, optionCombinationFactory);
    ProductFactory productFactory = new ProductFactory(optionInfoFactory);

    @Test
    @DisplayName("Product를 생성할 때, isOptionUsable이 true면 optionInfo를 생성한다.")
    void createProductWithIsOptionUsableTrue() {
        Product product = productFactory.createBy(anyProductRequestOf(true));

        assertThat(product.getOptionInfo()).isNotNull();
    }

    @Test
    @DisplayName("Product를 생성할 때, isOptionUsable이 false면 optionInfo는 null이다.")
    void createProductWithIsOptionUsableFalse() {
        Product product = productFactory.createBy(anyProductRequestOf(false));

        assertThat(product.getOptionInfo()).isNull();
    }

    @Test
    @DisplayName("ProductItem을 생성하면 Product도 함께 생성된다.")
    void createProductItem() {
        List<ProductItem> productItem = productFactory.createProductItem(anyProductRequestOf(true));

        assertThat(productItem.get(0).getProduct()).isNotNull();
    }

    @Test
    @DisplayName("ProductItem을 생성할 때, isOptionUsable이 true면 optionCombination은 null이 아니다.")
    void createProductItemWithIsOptionUsableTrue() {
        List<ProductItem> productItem = productFactory.createProductItem(anyProductRequestOf(true));

        assertThat(productItem.get(0).getOptionCombination()).isNotNull();
    }

    @Test
    @DisplayName("ProductItem을 생성할 때, isOptionUsable이 false면 optionCombination은 null이다.")
    void createProductItemWithIsOptionUsableFalse() {
        List<ProductItem> productItem = productFactory.createProductItem(anyProductRequestOf(false));

        assertThat(productItem.get(0).getOptionCombination()).isNull();
    }


    CreateProductRequest anyProductRequestOf(boolean isOptionUsable) {
        return new CreateProductRequest(
                "양말",
                "양말입니다.",
                1000,
                10,
                isOptionUsable,
                anyOptionRequestOf(),
                anyOptionCombinationRequestOf());
    }

    private static List<CreateOptionRequest> anyOptionRequestOf() {
        return List.of(
                new CreateOptionRequest("사이즈", List.of("S", "M")),
                new CreateOptionRequest("색상", List.of("red", "black"))
        );
    }

    private static List<CreateOptionCombinationRequest> anyOptionCombinationRequestOf() {
        return List.of(
                new CreateOptionCombinationRequest(List.of("S", "red"), 0, 10),
                new CreateOptionCombinationRequest(List.of("S", "black"), 0, 10),
                new CreateOptionCombinationRequest(List.of("M", "red"), 1000, 10),
                new CreateOptionCombinationRequest(List.of("M", "black"), 1000, 10)
        );
    }
}