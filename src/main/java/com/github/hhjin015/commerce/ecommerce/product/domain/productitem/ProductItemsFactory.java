package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductItemData;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductItemsFactory {

    private final OptionCombinationFactory optionCombinationFactory;

    public List<ProductItem> createBy(List<ProductItemData> productItemDatas, Product product) {
        List<ProductItem> productItems = new ArrayList<>();

        if (product.isOptionUsable()) {
            for (ProductItemData data : productItemDatas) {
                OptionCombination optionComb = optionCombinationFactory.createBy(data.getOptionCombinationData());
                productItems.add(new ProductItem(ProductItemId.of("ID"), product, data.getOptionCombinationData().getOptionCombQuantity(), optionComb));
            }
        } else {
            productItems.add(new ProductItem(ProductItemId.of("ID"), product, productItemDatas.get(0).getQuantity(), null));
        }

        return productItems;
    }
}
