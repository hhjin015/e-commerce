package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import org.springframework.stereotype.Component;

@Component
public class ProductItemInstantiation {
    public ProductItem instantiate(
            ProductItemId id,
            int salePrice,
            int quantity,
            OptionCombination optionCombination,
            ProductItemSalesStatus salesStatus
    ) {
        return ProductItem.builder()
                .id(id)
                .salePrice(salePrice)
                .quantity(quantity)
                .optionCombination(optionCombination)
                .salesStatus(salesStatus)
                .build();
    }
}
