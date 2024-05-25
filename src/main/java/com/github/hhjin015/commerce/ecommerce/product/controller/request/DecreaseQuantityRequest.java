package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DecreaseQuantityRequest {
    @NotNull
    @Min(1)
    private Integer decreaseAmount;
    @NotNull
    private String productId;
}
