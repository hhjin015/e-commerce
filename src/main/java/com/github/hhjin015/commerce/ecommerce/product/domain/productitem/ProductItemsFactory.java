package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class ProductItemsFactory {

    private final OptionCombinationFactory optionCombinationFactory;

    public List<ProductItem> createBy(List<ProductItemData> productItemsData, Product product) {
        List<ProductItem> productItems = new ArrayList<>();

        if (nonNull(product.getOptions())) {
            for (ProductItemData data : productItemsData) {
                OptionCombination optionComb = optionCombinationFactory.createBy(data.getOptionCombinationData());
                productItems.add(
                        new ProductItem(
                                ProductItemId.of(UUID.randomUUID().toString()),
                                product,
                                data.getQuantity(),
                                optionComb
                        )
                );
            }
        } else {
            productItems.add(
                    new ProductItem(
                            ProductItemId.of(UUID.randomUUID().toString()),
                            product,
                            productItemsData.get(0).getQuantity(),
                            null
                    )
            );
        }

        return productItems;
    }
}
