package com.github.hhjin015.commerce.ecommerce.product.mapper;

import com.github.hhjin015.commerce.ecommerce.product.domain.ProductSalesStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    ProductSalesStatus toProductSalesStatus(String status);
}
