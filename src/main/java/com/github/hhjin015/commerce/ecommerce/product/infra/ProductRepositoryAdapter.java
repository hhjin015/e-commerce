package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductEntity;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductItemEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductItemJpaRepository productItemJpaRepository;
    private final DomainConverter converter;

    @Override
    @Transactional
    public ProductId save(Product product) {
        ProductEntity productEntity = productJpaRepository.save(ProductEntity.toEntity(product));

        List<ProductItemEntity> list = new ArrayList<>();
        for (ProductItem pi : product.getProductItems()) {
            list.add(ProductItemEntity.toEntity(productEntity, pi));
        }

        productItemJpaRepository.saveAll(list);
        productItemJpaRepository.deleteAll(list);
        return ProductId.of(String.valueOf(productEntity.getId()));
    }

    @Override
    public Optional<Product> findBy(ProductId productId) {
        Long id = Long.parseLong(productId.getValue());
        Optional<ProductEntity> optProductEntity = productJpaRepository.findById(id);
        if (optProductEntity.isEmpty()) return Optional.empty();

        List<ProductItemEntity> productItemEntityList = productItemJpaRepository.findAllByProductId(id);
        return Optional.of(converter.toProductDomain(optProductEntity.get(), productItemEntityList));
    }

    @Override
    public Optional<ProductItem> findProductItemBy(ProductItemId id) {
        Optional<ProductItemEntity> optPi = productItemJpaRepository.findById(Long.parseLong(id.getValue()));
        if (optPi.isEmpty()) return Optional.empty();
        return Optional.of(converter.toProductItemDomain(optPi.get()));
    }
}
