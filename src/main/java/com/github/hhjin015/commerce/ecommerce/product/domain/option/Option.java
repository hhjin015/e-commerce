package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@Builder(access = AccessLevel.PROTECTED)
@ToString
public class Option {
    String name;
    List<String> values;
}
