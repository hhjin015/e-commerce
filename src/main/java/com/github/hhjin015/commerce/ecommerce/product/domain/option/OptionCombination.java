package com.github.hhjin015.commerce.ecommerce.product.domain.option;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder(access = AccessLevel.PROTECTED)
@ToString
public class OptionCombination {
    String optionNames;
    int additionalPrice;
}
