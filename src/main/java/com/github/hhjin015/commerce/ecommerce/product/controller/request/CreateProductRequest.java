package com.github.hhjin015.commerce.ecommerce.product.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateProductRequest {
    @JsonProperty("product")
    private ProductDto productDto;

    @JsonProperty("productItems")
    private List<ProductItemDto> productItemsDto;
}
