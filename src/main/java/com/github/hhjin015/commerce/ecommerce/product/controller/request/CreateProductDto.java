package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductData;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Getter
@NoArgsConstructor
public class CreateProductDto {
    private String name;
    private String description;
    private int price;
    @JsonProperty("options")
    private List<OptionDto> optionsDto;

    public ProductData toData() {
        List<OptionData> list = null;

        if (nonNull(optionsDto)) {
            list = new ArrayList<>();
            for (OptionDto dto : optionsDto) {
                list.add(dto.toData());
            }
        }
        return new ProductData(name, description, price, list);
    }
}
