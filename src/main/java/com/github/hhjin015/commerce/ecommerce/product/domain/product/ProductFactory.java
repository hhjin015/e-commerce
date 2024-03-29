package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.datas.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductFactory {

    private final OptionFactory optionFactory;

    public Product createBy(ProductData productData) {
        List<Option> options = null;

        if (productData.isOptionUsable()) {
            options = new ArrayList<>();

            for (OptionData optionProp : productData.getOptionProps()) {
                options.add(optionFactory.createBy(optionProp));
            }
        }

        return new Product(
                UUID.randomUUID().toString(),
                productData.getName(),
                productData.getDescription(),
                productData.getPrice(),
                productData.isOptionUsable(),
                options
        );
    }
}
