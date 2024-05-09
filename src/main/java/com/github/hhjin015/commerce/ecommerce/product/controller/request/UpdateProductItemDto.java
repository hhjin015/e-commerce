package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.UpdateProductItemData;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProductItemDto {

    private String productItemId;
    @NotNull @Min(0)
    private Integer quantity;
    @NotNull
    private Integer additionalPrice;

    public UpdateProductItemData toData() {
        return new UpdateProductItemData(productItemId, quantity, additionalPrice);
    }
}
