package com.github.hhjin015.commerce.ecommerce.product.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Converter(autoApply = true)
@RequiredArgsConstructor
public class OptionCombinationListConverter implements AttributeConverter<List<OptionCombinationEntity>, String> {

    private final ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(List<OptionCombinationEntity> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OptionCombinationEntity> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}