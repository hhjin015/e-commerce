package com.github.hhjin015.commerce.ecommerce.product.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionData {
    private String name;
    private List<String> values;
}
