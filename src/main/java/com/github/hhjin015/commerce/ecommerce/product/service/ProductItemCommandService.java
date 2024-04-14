package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemRepository;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemsFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ModifyProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductItemData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class
ProductItemCommandService {

    private final ProductItemRepository productItemRepository;
    private final ProductRepository productRepository;
    private final ProductItemsFactory productItemsFactory;

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

    public void addProductItem(String productId, List<ProductItemData> data) {
        Product product = productRepository.findBy(ProductId.of(productId));
        List<ProductItem> productItems = productItemsFactory.createBy(data, product);
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
            productItem.updateQuantity(data.getQuantity());

            productItemRepository.save(productItem);
        }
    }
}
