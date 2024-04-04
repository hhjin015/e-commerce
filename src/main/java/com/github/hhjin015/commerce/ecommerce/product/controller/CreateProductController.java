package com.github.hhjin015.commerce.ecommerce.product.controller;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.request.*;
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

@RestController
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductService createProductService;

    @PostMapping("/product")
    public ResponseEntity<ProductId> createProduct(@RequestBody ProductAndProductItemRequest request) {
        ProductData productData = parseProductRequestToData(request.getProductRequest());
        List<ProductItemData> productItemData = parseProductItemRequestToData(request.getProductItemRequests());
        ProductId productId = createProductService.create(productData, productItemData);

        return ResponseEntity.ok(productId);
    }


    private ProductData parseProductRequestToData(ProductRequest request) {
        return new ProductData(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.isOptionUsable(),
                parseOptionRequestToData(request.getOptionRequests())
        );
    }

    private List<OptionData> parseOptionRequestToData(List<OptionRequest> requests) {
        if (requests == null) return null;

        List<OptionData> optionDatas = new ArrayList<>();
        for (OptionRequest request : requests) {
            optionDatas.add(new OptionData(request.getName(), request.getValues()));
        }

        return optionDatas;
    }

    private List<ProductItemData> parseProductItemRequestToData(List<ProductItemRequest> requests) {
        List<ProductItemData> productItemDatas = new ArrayList<>();

        for (ProductItemRequest request : requests) {
            productItemDatas.add(
                    new ProductItemData(
                            request.getQuantity(),
                            parseOptionCombinationRequestToData(request.getOptionCombinationRequest())
                    )
            );
        }

        return productItemDatas;
    }

    private OptionCombinationData parseOptionCombinationRequestToData(OptionCombinationRequest request) {
        if (request == null) return null;

        return new OptionCombinationData(request.getOptionNames(), request.getAdditionalPrice(), request.getOptionCombQuantity());
    }
}
