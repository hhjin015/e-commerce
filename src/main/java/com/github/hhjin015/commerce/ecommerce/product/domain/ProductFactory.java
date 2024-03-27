package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Product와 ProductItem은 항상 같이 생성된다.
 */
@RequiredArgsConstructor
public class ProductFactory {

    private final OptionInfoFactory optionInfoFactory;

    public Product createBy(CreateProductRequest productRequest) {
        OptionInfo optionInfo = null;

        if (productRequest.isOptionUsable()) {
            optionInfo = optionInfoFactory.createBy(productRequest.getOptionRequests(), productRequest.getOptionCombinationRequests());
        }

        return new Product(UUID.randomUUID().toString(), productRequest.getName(), productRequest.getDescription(), productRequest.getPrice(),
                productRequest.getQuantity(), productRequest.isOptionUsable(), optionInfo);
    }

    public List<ProductItem> createProductItem(CreateProductRequest productRequest) {
        Product product = createBy(productRequest);
        List<ProductItem> productItems = new ArrayList<>();

        if (product.isOptionUsable()) {
            for (OptionCombination optionCombination : product.getOptionInfo().getOptionCombinations()) {
                productItems.add(new ProductItem(UUID.randomUUID().toString(), product, optionCombination));
            }
        } else {
            productItems.add(new ProductItem(UUID.randomUUID().toString(), product, null));
        }

        return productItems;
    }
}
