package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hhjin015.commerce.ecommerce.product.service.data.CreateProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemsData;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Getter
@NoArgsConstructor
public class CreateProductRequest {

    @JsonProperty("product")
    private CreateProductDto productDto;

    @JsonProperty("productItems")
    private List<CreateProductItemDto> productItemsDto;

    public CreateProductData toData() {
        List<ProductItemData> list = new ArrayList<>();
        for (CreateProductItemDto dto : productItemsDto) {
            list.add(dto.toData());
        }

        ProductData productData = productDto.toData();
        ProductItemsData productItemsData = new ProductItemsData(list, nonNull(productData.getOptionsData()), productData.getPrice());

        return new CreateProductData(productData, productItemsData);
    }
}
