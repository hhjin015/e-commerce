package com.github.hhjin015.commerce.ecommerce.product.mapper;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductItemStatusType;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    ProductSalesStatus toProductSalesStatus(String status);
    ProductSalesStatus toProductSalesStatus(ProductStatusType type);
    ProductStatusType toProductStatusType(ProductSalesStatus status);

    ProductItemSalesStatus toProductItemSalesStatus(ProductItemStatusType type);
    ProductItemStatusType toProductItemStatusType(ProductItemSalesStatus status);
}
