package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemsFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.data.CreateProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateProductService {

    private final ProductFactory productFactory;
    private final ProductRepository productRepository;
    private final ProductItemsFactory productItemsFactory;
    private final ProductItemRepository productItemRepository;

    public ProductId create(CreateProductData data) {
        Product product = productFactory.createBy(data.getProductData());
        List<ProductItem> productItems = productItemsFactory.createBy(data.getProductItemsData(), product);

        for (ProductItem productItem : productItems) {
            productItemRepository.save(productItem);
        }

        productRepository.save(product);
        return product.getId();
    }
}
