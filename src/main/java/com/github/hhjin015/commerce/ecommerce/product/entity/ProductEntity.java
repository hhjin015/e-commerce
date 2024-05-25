package com.github.hhjin015.commerce.ecommerce.product.entity;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.mapper.StatusMapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;

    @Column(columnDefinition = "JSON")
    @Convert(converter = OptionListConverter.class)
    private List<OptionEntity> options;

    @Enumerated(EnumType.STRING)
    private ProductStatusType status;

    public static ProductEntity toEntity(Product domain) {
        List<OptionEntity> list = Optional.ofNullable(domain.getOptions())
                .map(options -> options.stream()
                        .map(OptionEntity::toEntity)
                        .collect(Collectors.toList()))
                .orElse(null);

        return ProductEntity.builder()
                .id(isNull(domain.getId()) ? null : Long.parseLong(domain.getId().getValue()))
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice())
                .options(list)
                .status(StatusMapper.INSTANCE.toProductStatusType(domain.getSalesStatus()))
                .build();
    }
}
