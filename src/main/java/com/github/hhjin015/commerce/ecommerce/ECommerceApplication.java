package com.github.hhjin015.commerce.ecommerce;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.infra.HashMapProductItemRepository;
import com.github.hhjin015.commerce.ecommerce.product.infra.HashMapProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(HashMapProductRepository productRepository, HashMapProductItemRepository productItemRepository) {
        return args -> {
            Product product = new Product(
                    ProductId.of("productId"),
                    "양말",
                    "양말 사세요",
                    1000,
                    List.of(Option.of("size", List.of("S", "M", "L")))
            );
            productRepository.save(product);

            productItemRepository.save(
                    new ProductItem(
                            ProductItemId.of("productItem1"),
                            product,
                            10,
                            OptionCombination.of(List.of("S"), 0)
                    )
            );

            productItemRepository.save(
                    new ProductItem(
                            ProductItemId.of("productItem2"),
                            product,
                            20,
                            OptionCombination.of(List.of("M"), 1000)
                    )
            );

            productItemRepository.save(
                    new ProductItem(
                            ProductItemId.of("productItem3"),
                            product,
                            30,
                            OptionCombination.of(List.of("L"), 2000)
                    )
            );
        };
    }
}
