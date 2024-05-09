package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.RemoveProductItemData;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RemoveProductItemDto {
    private String id;

    public RemoveProductItemData toData() {
        return new RemoveProductItemData(id);
    }
}
