package com.github.hhjin015.commerce.ecommerce.product.event;

import com.github.hhjin015.commerce.ecommerce.product.service.ProductItemCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPriceChangedEventHandler {

    private final ProductItemCommandService productItemCommandService;

    @EventListener(ProductPriceChangedEvent.class)
    public void handle(ProductPriceChangedEvent event) {
        productItemCommandService.modifySalePrice(event.getProductId());
    }
}
