package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.service.data.CreateProductData;
import com.github.hhjin015.commerce.ecommerce.product.domain.support.AbstractFactoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateProductTest extends AbstractFactoryTest {

    @Autowired
    CreateProductService sut;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상품 생성")
    void createProduct() {
        ProductId actual = sut.create(getCreateProductData());
        Optional<Product> optionalProduct = productRepository.findBy(actual);

        assertThat(optionalProduct).isNotNull();
        assertThat(actual).isEqualTo(optionalProduct.get().getId());
    }

    private static CreateProductData getCreateProductData() {
        return new CreateProductData(getProductData(getOptionDataList()), getProductItemsDataWithOption());
    }
}
