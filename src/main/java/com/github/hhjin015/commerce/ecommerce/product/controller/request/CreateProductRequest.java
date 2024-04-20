package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hhjin015.commerce.ecommerce.product.service.data.CreateProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateProductRequest {

    @JsonProperty("product")
    private ProductDto productDto;

    @JsonProperty("productItems")
    private List<ProductItemDto> productItemsDto;

    public CreateProductData toData() {
        List<ProductItemData> list = new ArrayList<>();
        for (ProductItemDto dto : productItemsDto) {
            list.add(dto.toData());
        }

        return new CreateProductData(productDto.toData(), list);
    }
}
