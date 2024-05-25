package com.github.hhjin015.commerce.ecommerce.product.infra;

import com.github.hhjin015.commerce.ecommerce.product.entity.ProductItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemJpaRepository extends JpaRepository<ProductItemEntity, Long> {

    List<ProductItemEntity> findAllByProductId(Long id);

}
