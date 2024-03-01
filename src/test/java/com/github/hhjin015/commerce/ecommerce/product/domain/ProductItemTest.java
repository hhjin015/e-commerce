package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.infra.HashMapProductItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProductItemTest {

    Product product;

    @Test
    void registerProduct() {

        HashMapProductItemRepository hashMapProductItemRepository = new HashMapProductItemRepository();

        OptionName size = new OptionName(1, "사이즈");
        OptionName color = new OptionName(2, "색상");

        OptionValue small = new OptionValue(1, size, "small");
        OptionValue medium = new OptionValue(2, size, "medium");
        OptionValue large = new OptionValue(3, size, "large");
        OptionValue red = new OptionValue(4, color, "red");
        OptionValue blue = new OptionValue(5, color, "blue");

        Option option1 = new Option(1, size, small, 0);
        Option option2 = new Option(2, size, medium, 1000);
        Option option3 = new Option(3, size, large, 2000);
        Option option4 = new Option(4, color, red, 0);
        Option option5 = new Option(5, color, blue, 0);

        List<Option> options = new ArrayList<>();

        options.add(option1);
        options.add(option4);

        product = new Product(1, "테디베어 양말", "애기들 양말입니다.", 1000, options, 4);

        hashMapProductItemRepository.save(product);

        Assertions.assertThat(hashMapProductItemRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void buy() {
        // 테디베어 양말, small, red
        new ProductItem(1, product, 0)
    }
}
