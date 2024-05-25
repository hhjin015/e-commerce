package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductFactory {

    private final OptionFactory optionFactory;

    public Product createBy(ProductData productData, List<ProductItem> productItems) {
        List<Option> options = Optional.ofNullable(productData.getOptionsData())
                .map(this::createOptions)
                .orElse(null);

        return Product.builder()
                .name(productData.getName())
                .description(productData.getDescription())
                .price(productData.getPrice())
                .options(options)
                .productItems(productItems)
                .build();
    }

    private List<Option> createOptions(List<OptionData> optionDataList) {
        return optionDataList.stream()
                .map(optionFactory::createBy)
                .collect(Collectors.toList());
    }
}
