package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationInstantiation;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionInstantiation;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductInstantiation;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemInstantiation;
import com.github.hhjin015.commerce.ecommerce.product.entity.OptionCombinationEntity;
import com.github.hhjin015.commerce.ecommerce.product.entity.OptionEntity;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductEntity;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductItemEntity;
import com.github.hhjin015.commerce.ecommerce.product.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class DomainConverter {

    private final ProductInstantiation productInstantiation;
    private final ProductItemInstantiation productItemInstantiation;
    private final OptionInstantiation optionInstantiation;
    private final OptionCombinationInstantiation optionCombinationInstantiation;

    Product toProductDomain(ProductEntity pEntity, List<ProductItemEntity> piEntity) {
        return productInstantiation.instantiate(
                ProductId.of(Long.toString(pEntity.getId())),
                pEntity.getName(),
                pEntity.getDescription(),
                pEntity.getPrice(),
                nonNull(pEntity.getOptions()) ? toOptionDomain(pEntity.getOptions()) : null,
                toProductItemListDomain(piEntity),
                StatusMapper.INSTANCE.toProductSalesStatus(pEntity.getStatus())
        );
    }

    ProductItem toProductItemDomain(ProductItemEntity entity) {
        return productItemInstantiation.instantiate(
                ProductItemId.of(String.valueOf(entity.getId())),
                entity.getSalePrice(),
                entity.getQuantity(),
                nonNull(entity.getOptionCombination()) ? toOptionCombinationDomain(entity.getOptionCombination(), entity.getAdditionalPrice()) : null,
                StatusMapper.INSTANCE.toProductItemSalesStatus(entity.getStatus())
        );
    }

    List<ProductItem> toProductItemListDomain(List<ProductItemEntity> entities) {
        List<ProductItem> list = new ArrayList<>();

        for (ProductItemEntity e : entities) {
            list.add(productItemInstantiation.instantiate(
                    ProductItemId.of(String.valueOf(e.getId())),
                    e.getSalePrice(),
                    e.getQuantity(),
                    toOptionCombinationDomain(e.getOptionCombination(), e.getAdditionalPrice()),
                    StatusMapper.INSTANCE.toProductItemSalesStatus(e.getStatus())
            ));
        }
        return list;
    }

    OptionCombination toOptionCombinationDomain(List<OptionCombinationEntity> entities, int additionalPrice) {
        if(isNull(entities)) return null;
        String concatenatedValues = entities.stream()
                .map(OptionCombinationEntity::getValue)
                .collect(Collectors.joining(","));

        return optionCombinationInstantiation.instantiate(concatenatedValues, additionalPrice);
    }

    List<Option> toOptionDomain(List<OptionEntity> entities) {
        return entities.stream()
                .map(e -> optionInstantiation.instantiate(e.getName(), new ArrayList<>(e.getValues())))
                .collect(Collectors.toList());
    }
}
