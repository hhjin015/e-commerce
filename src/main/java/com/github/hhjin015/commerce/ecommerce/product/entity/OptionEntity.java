package com.github.hhjin015.commerce.ecommerce.product.entity;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class OptionEntity {
    private String name;
    private Set<String> values;

    public static OptionEntity toEntity(Option domain) {
        return new OptionEntity(domain.getName(), new HashSet<>(domain.getValues()));
    }
}
