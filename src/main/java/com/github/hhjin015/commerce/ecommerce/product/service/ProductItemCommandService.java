package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemsFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class
ProductItemCommandService {

    private final ProductItemRepository productItemRepository;
    private final ProductRepository productRepository;
    private final ProductItemsFactory productItemsFactory;
    private final OptionCombinationFactory optionCombinationFactory;

    public void modifySalePrice(ProductId id) {
        List<ProductItem> productItems = productItemRepository.findAllBy(id);

        for (ProductItem productItem : productItems) {
            productItem.updateSalePrice();
            productItemRepository.save(productItem);
        }
    }

    public void decreaseQuantity(String id, int amount) {
        ProductItem productItem = productItemRepository.findBy(ProductItemId.of(id));
        productItem.decreaseQuantity(amount);
    }

    public void addProductItem(String productId, List<ProductItemData> dataList) {
        Product product = productRepository.findBy(ProductId.of(productId));

        for (ProductItemData data : dataList) {
            if(isNull(product.getOptions()) && nonNull(data.getOptionCombinationData())) {
                throw new IllegalStateException("상품의 옵션을 먼저 설정해주세요");
            }
        }

        List<ProductItem> productItems = productItemsFactory.createBy(dataList, product);
        for (ProductItem productItem : productItems) {
            productItemRepository.save(productItem);
        }
    }

    public void deleteProductItem(List<String> ids) {
        for (String id : ids) {
            productItemRepository.deleteBy(ProductItemId.of(id));
        }
    }

    public void modifyProductItem(List<ModifyProductItemData> dataList) {
        for (ModifyProductItemData data : dataList) {
            ProductItem productItem = productItemRepository.findBy(ProductItemId.of(data.getProductItemId()));
            OptionCombination optionComb = optionCombinationFactory.createBy(
                    new OptionCombinationData(productItem.getOptionCombination().getOptionNames(), data.getAdditionalPrice())
            );
            productItem.update(data.getQuantity(), optionComb);

            productItemRepository.save(productItem);
        }
    }
}
