package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductItemsFactory {

    private final OptionCombinationFactory optionCombinationFactory;

    public List<ProductItem> createBy(ProductItemsData productItemsData) {
        return productItemsData.getProductItemsData().stream()
                .map(data -> createProductItem(productItemsData, data))
                .collect(Collectors.toList());
    }

    private ProductItem createProductItem(ProductItemsData productItemsData, ProductItemData productItemData) {
        String itemId = UUID.randomUUID().toString();
        int price = calculateSalePrice(productItemsData.isOptionUsable(), productItemsData.getDefaultPrice(), productItemData.getOptionCombinationData());
        int quantity = productItemData.getQuantity();

        OptionCombination optionCombination = createOptionCombination(productItemsData.isOptionUsable(), productItemData);

        return new ProductItem(ProductItemId.of(itemId), price, quantity, optionCombination);
    }

    private int calculateSalePrice(boolean isOptionUsable, int defaultPrice, OptionCombinationData optionCombinationData) {
        if (!isOptionUsable) return defaultPrice;
        else return defaultPrice + optionCombinationData.getAdditionalPrice();
    }

    private OptionCombination createOptionCombination(boolean isOptionUsable, ProductItemData data) {
        if (!isOptionUsable) return null;
        return optionCombinationFactory.createBy(data.getOptionCombinationData());
    }
}
