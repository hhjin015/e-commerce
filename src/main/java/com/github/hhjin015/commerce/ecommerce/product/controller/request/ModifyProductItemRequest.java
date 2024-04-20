package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ModifyProductItemRequest {

    @NotEmpty
    private String operation;
    private List<String> removeIds;
    private String productId;
    private List<ProductItemDto> createPIs;
    @Valid
    private List<ModifyProductItemDto> modifyPIs;

    public List<ProductItemData> productItemDtoToData() {
        List<ProductItemData> list = new ArrayList<>();

        for(ProductItemDto dto : createPIs) {
            list.add(dto.toData());
        }

        return list;
    }

    public List<ModifyProductItemData> modifyProductItemDtoToData() {
        List<ModifyProductItemData> list = new ArrayList<>();

        for(ModifyProductItemDto dto : modifyPIs) {
            list.add(dto.toData());
        }

        return list;
    }
}
