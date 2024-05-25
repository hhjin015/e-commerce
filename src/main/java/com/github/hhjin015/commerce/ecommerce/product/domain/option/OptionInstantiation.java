package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OptionInstantiation {

    public Option instantiate(String name, List<String> values) {
        return Option.builder()
                .name(name)
                .values(values)
                .build();
    }
}
