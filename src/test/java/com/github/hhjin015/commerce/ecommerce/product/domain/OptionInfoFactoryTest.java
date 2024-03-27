package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionCombinationRequest;
import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OptionInfoFactoryTest {

    OptionFactory optionFactory = new OptionFactory();
    OptionCombinationFactory optionCombinationFactory = new OptionCombinationFactory();
    OptionInfoFactory optionInfoFactory = new OptionInfoFactory(optionFactory, optionCombinationFactory);

    @Test
    @DisplayName("OptionInfoFactory가 Option과 OptionCombination으로 OptionInfo를 생성한다.")
    void createOptionInfo() {
        OptionInfo optionInfo = optionInfoFactory.createBy(anyOptionRequestOf(), anyOptionCombinationRequestOf());

        assertThat(optionInfo.getOptions().get(0)).isInstanceOf(Option.class);
        assertThat(optionInfo.getOptionCombinations().get(0)).isInstanceOf(OptionCombination.class);
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