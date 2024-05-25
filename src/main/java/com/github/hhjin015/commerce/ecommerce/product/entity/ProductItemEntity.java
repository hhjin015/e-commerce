package com.github.hhjin015.commerce.ecommerce.product.entity;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.mapper.StatusMapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_items")
public class ProductItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int salePrice;
    private int quantity;
    private int additionalPrice;

    @Column(columnDefinition = "JSON")
    @Convert(converter = OptionCombinationListConverter.class)
    private List<OptionCombinationEntity> optionCombination;

    @Enumerated(EnumType.STRING)
    private ProductItemStatusType status;

    @ManyToOne
    private ProductEntity product;

    public static ProductItemEntity toEntity(ProductEntity pEntity, ProductItem domain) {
        OptionCombination oc = domain.getOptionCombination();
        return ProductItemEntity.builder()
                .id(isNull(domain.getId()) ? null : Long.parseLong(domain.getId().getValue()))
                .salePrice(domain.getSalePrice())
                .quantity(domain.getQuantity())
                .product(pEntity)
                .additionalPrice(nonNull(oc) ? oc.getAdditionalPrice() : 0)
                .optionCombination(nonNull(oc) ? getOptionCombinationEntitySet(oc, pEntity.getOptions()) : null)
                .status(StatusMapper.INSTANCE.toProductItemStatusType(domain.getSalesStatus()))
                .build();
    }

    private static List<OptionCombinationEntity> getOptionCombinationEntitySet(OptionCombination oc, List<OptionEntity> optionEntitySet) {
        List<OptionCombinationEntity> list = new ArrayList<>();
        String[] optionNames = oc.getOptionNames().split(",");

        if (optionNames.length != optionEntitySet.size()) {
            throw new IllegalArgumentException("옵션의 갯수가 일치하지 않습니다.");
        }

        Iterator<OptionEntity> optionEntityIterator = optionEntitySet.iterator();
        for (String optionName : optionNames) {
            if (optionEntityIterator.hasNext()) {
                OptionEntity oe = optionEntityIterator.next();
                list.add(OptionCombinationEntity.toEntity(oe.getName(), optionName));
            }
        }
        return list;
    }
}
