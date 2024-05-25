package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInstantiation {
    public Product instantiate(
            ProductId id,
            String name,
            String description,
            int price,
            List<Option> options,
            List<ProductItem> productItems,
            ProductSalesStatus salesStatus
    ) {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .options(options)
                .productItems(productItems)
                .salesStatus(salesStatus)
                .build();
    }
}
