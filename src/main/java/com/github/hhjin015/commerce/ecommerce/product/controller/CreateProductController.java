package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.controller.request.*;
import com.github.hhjin015.commerce.ecommerce.product.controller.response.ProductIdResponse;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.service.CreateProductService;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionCombinationData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductService createProductService;

    @PostMapping("/products")
    public ResponseEntity<ProductIdResponse> createProduct(@RequestBody CreateProductRequest request) {
        ProductData productData = parseProductDtoToData(request.getProductDto());
        List<ProductItemData> productItemData = parseProductItemDtoToData(request.getProductItemsDto());
        ProductId productId = createProductService.create(productData, productItemData);

        return ResponseEntity.ok(ProductIdResponse.of(productId.getValue()));
    }

    private ProductData parseProductDtoToData(ProductDto request) {
        return new ProductData(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.isOptionUsable(),
                parseOptionDtoToData(request.getOptionsDto())
        );
    }

    private List<OptionData> parseOptionDtoToData(List<OptionDto> requests) {
        if (isNull(requests)) return null;

        List<OptionData> optionsData = new ArrayList<>();
        for (OptionDto request : requests) {
            optionsData.add(new OptionData(request.getName(), request.getValues()));
        }

        return optionsData;
    }

    private List<ProductItemData> parseProductItemDtoToData(List<ProductItemDto> requests) {
        List<ProductItemData> productItemsData = new ArrayList<>();

        for (ProductItemDto request : requests) {
            productItemsData.add(
                    new ProductItemData(
                            request.getQuantity(),
                            parseOptionCombinationDtoToData(request.getOptionCombinationDto())
                    )
            );
        }

        return productItemsData;
    }

    private OptionCombinationData parseOptionCombinationDtoToData(OptionCombinationDto request) {
        if (isNull(request)) return null;

        return new OptionCombinationData(request.getOptionNames(), request.getAdditionalPrice(), request.getOptionCombQuantity());
    }
}
