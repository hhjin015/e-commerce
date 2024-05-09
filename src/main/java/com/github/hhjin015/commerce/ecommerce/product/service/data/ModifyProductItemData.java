package com.github.hhjin015.commerce.ecommerce.product.service.data;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ModifyProductItemData {
    private Product product;
    private List<ProductItemData> addData;
    private List<UpdateProductItemData> updateData;
    private List<RemoveProductItemData> removeData;
}
