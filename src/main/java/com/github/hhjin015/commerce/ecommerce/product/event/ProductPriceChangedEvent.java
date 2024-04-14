package com.github.hhjin015.commerce.ecommerce.product.event;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductPriceChangedEvent {
    private ProductId productId;
}
