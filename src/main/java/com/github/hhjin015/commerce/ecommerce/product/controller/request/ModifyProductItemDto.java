package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductItemData;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyProductItemDto {

    private String productItemId;
    @NotNull @Min(0)
    private Integer quantity;
    @NotNull
    private Integer additionalPrice;

    public ModifyProductItemData toData() {
        return new ModifyProductItemData(productItemId, quantity, additionalPrice);
    }
}
