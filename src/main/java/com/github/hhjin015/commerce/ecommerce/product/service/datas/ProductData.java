package com.github.hhjin015.commerce.ecommerce.product.service.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductData {
    private String name;
    private String description;
    private int price;
    private boolean optionUsable;
    private List<OptionData> optionDatas;

}
