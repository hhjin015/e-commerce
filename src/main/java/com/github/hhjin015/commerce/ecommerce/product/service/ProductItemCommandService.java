package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemsFactory;
import com.github.hhjin015.commerce.ecommerce.product.entity.ProductItemEntity;
import com.github.hhjin015.commerce.ecommerce.product.infra.ProductItemJpaRepository;
import com.github.hhjin015.commerce.ecommerce.product.service.data.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ProductItemCommandService {

    private final ProductRepository productRepository;
    private final ProductItemsFactory productItemsFactory;
    private final OptionCombinationFactory optionCombinationFactory;


    public void decreaseQuantity(String productItemId, String productId, int amount) {
        Product product = productRepository.findBy(ProductId.of(productId))
                .orElseThrow(() -> new NoSuchElementException("해당 상품이 존재하지 않습니다.."));

        ProductItem productItem = product.getProductItem(ProductItemId.of(productItemId))
                .orElseThrow(() -> new NoSuchElementException("해당 상품 아이템이 존재하지 않습니다."));

        productItem.decreaseQuantity(amount);
        productRepository.save(product);
    }

    @Transactional
    public void modifyProductItem(ModifyProductItemData data) {
        Product product = productRepository.findBy(ProductId.of(data.getProductId()))
                .orElseThrow(() -> new NoSuchElementException("해당 상품이 존재하지 않습니다."));

        if (product.getOptions() == null) {
            throw new IllegalArgumentException();
        }

        add(nonNull(product.getOptions()), product, data.getAddData());
        update(product, data.getUpdateData());
        remove(product, data.getRemoveData());

        productRepository.save(product);
    }

    private void remove(Product product, List<RemoveProductItemData> removeData) {
        if (isNull(removeData)) return;

        for (RemoveProductItemData data : removeData) {
            product.removeProductItem(ProductItemId.of(data.getId()));
        }
    }

    private void update(Product product, List<UpdateProductItemData> updateData) {
        if (isNull(updateData)) return;

        updateData.forEach(data -> {
            ProductItemId targetItemId = ProductItemId.of(data.getProductItemId());
            boolean found = product.getProductItems().stream()
                    .filter(pi -> targetItemId.equals(pi.getId()))
                    .findFirst()
                    .map(pi -> {
                        OptionCombination newOptionComb = getNewOptionCombination(pi.getOptionCombination(), data.getAdditionalPrice());
                        pi.update(data.getQuantity(), newOptionComb, product.getPrice());
                        return true;
                    })
                    .orElse(false);

            if (!found) {
                throw new NoSuchElementException("해당 상품아이템이 존재하지 않습니다.");
            }
        });
    }

    private void add(boolean optionUsable, Product product, List<ProductItemData> addData) {
        if (isNull(addData)) return;

        ProductItemsData productItemsData = new ProductItemsData(addData, optionUsable, product.getPrice());
        List<ProductItem> productItems = productItemsFactory.createBy(productItemsData);

        product.addProductItems(productItems);
    }

    private OptionCombination getNewOptionCombination(OptionCombination old, int additionalPrice) {
        return optionCombinationFactory.createBy(
                new OptionCombinationData(old.getOptionNames(), additionalPrice)
        );
    }
}


