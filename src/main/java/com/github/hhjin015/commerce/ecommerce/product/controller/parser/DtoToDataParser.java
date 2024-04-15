package com.github.hhjin015.commerce.ecommerce.product.controller.parser;

import com.github.hhjin015.commerce.ecommerce.product.controller.request.*;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class DtoToDataParser {

    public ProductData parseProductDtoToData(ProductDto dto) {
        return new ProductData(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                parseOptionDtoToData(dto.getOptionsDto())
        );
    }

    public List<ProductItemData> parseProductItemDtoToData(List<ProductItemDto> dtoList) {
        List<ProductItemData> productItemsData = new ArrayList<>();

        for (ProductItemDto request : dtoList) {
            productItemsData.add(
                    new ProductItemData(
                            request.getQuantity(),
                            parseOptionCombinationDtoToData(request.getOptionCombinationDto())
                    )
            );
        }

        return productItemsData;
    }

    public List<OptionData> parseOptionDtoToData(List<OptionDto> dtoList) {
        if (isNull(dtoList)) return null;

        List<OptionData> optionsData = new ArrayList<>();
        for (OptionDto request : dtoList) {
            optionsData.add(new OptionData(request.getName(), request.getValues()));
        }

        return optionsData;
    }

    public OptionCombinationData parseOptionCombinationDtoToData(OptionCombinationDto dto) {
        if (isNull(dto)) return null;

        return new OptionCombinationData(dto.getOptionNames(), dto.getAdditionalPrice());
    }

    public List<ModifyProductItemData> parseModifyProductItemDtoToData(List<ModifyProductItemDto> dtoList) {
        List<ModifyProductItemData> list = new ArrayList<>();

        for (ModifyProductItemDto dto : dtoList) {
            list.add(new ModifyProductItemData(dto.getProductItemId(), dto.getQuantity(), dto.getAdditionalPrice()));
        }

        return list;
    }
}
