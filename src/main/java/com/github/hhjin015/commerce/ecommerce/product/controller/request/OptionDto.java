package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionDto {
    private String name;
    private List<String> values;

    public OptionData toData() {
        return new OptionData(name, values);
    }
}
