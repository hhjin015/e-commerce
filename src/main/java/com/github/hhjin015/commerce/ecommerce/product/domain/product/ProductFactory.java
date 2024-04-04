package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductFactory {

    private final OptionFactory optionFactory;

    public Product createBy(ProductData productData) {
        List<Option> options = null;

        if (productData.isOptionUsable()) {
            options = new ArrayList<>();

            for (OptionData optionData : productData.getOptionDatas()) {
                options.add(optionFactory.createBy(optionData));
            }
        }
        return new Product(
                ProductId.of(UUID.randomUUID().toString()),
                productData.getName(),
                productData.getDescription(),
                productData.getPrice(),
                productData.isOptionUsable(),
                options
        );
    }
}
