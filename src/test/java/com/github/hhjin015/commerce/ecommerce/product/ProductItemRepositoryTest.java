package com.github.hhjin015.commerce.ecommerce.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.ProductItemRepository;

import java.util.List;

class ProductItemRepositoryTest {

    ProductItemRepository sut = new ProductItemRepository() {

        @Override
        public List<Product> findAll() {
            return null;
        }

        @Override
        public void save(Product productItem) {

        }
    };

}