package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.RemoveProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.UpdateProductItemData;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Getter
@NoArgsConstructor
public class ModifyProductItemRequest {
    private List<CreateProductItemDto> add;
    @Valid
    private List<UpdateProductItemDto> update;
    private List<RemoveProductItemDto> remove;

    public ModifyProductItemData toData(String productId) {
        List<ProductItemData> addData = getAddData();

        List<UpdateProductItemData> updateData = getUpdateData();

        List<RemoveProductItemData> removeData = getRemoveData();

        return new ModifyProductItemData(productId, addData, updateData, removeData);
    }

    private List<ProductItemData> getAddData() {
        if (isNull(add)) return null;

        List<ProductItemData> addData = new ArrayList<>();
        for (CreateProductItemDto dto : add) {
            addData.add(dto.toData());
        }
        return addData;
    }

    private List<UpdateProductItemData> getUpdateData() {
        if (isNull(update)) return null;

        List<UpdateProductItemData> updateData = new ArrayList<>();
        for (UpdateProductItemDto dto : update) {
            updateData.add(dto.toData());
        }

        return updateData;
    }

    private List<RemoveProductItemData> getRemoveData() {
        if (isNull(remove)) return null;

        List<RemoveProductItemData> removeData = new ArrayList<>();
        for (RemoveProductItemDto dto : remove) {
            removeData.add(dto.toData());
        }

        return removeData;
    }
}
