package com.github.hhjin015.commerce.ecommerce.product.domain.support;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductInstantiation;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemsFactory;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemsData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDomainTest extends AbstractFactoryTest {

    OptionFactory optionFactory = new OptionFactory();
    OptionCombinationFactory optionCombinationFactory = new OptionCombinationFactory();
    ProductItemsFactory productItemsFactory = new ProductItemsFactory(optionCombinationFactory);
    ProductFactory productFactory = new ProductFactory(optionFactory);
    ProductInstantiation instantiation = new ProductInstantiation();

    public List<ProductItem> getProductItems(int count) {
        List<ProductItemData> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new ProductItemData(0, null));
        }

        return productItemsFactory.createBy(new ProductItemsData(list, false, 0));
    }

    public Product getProduct(int productItemCount) {
        Product p = productFactory.createBy(getProductData(getOptionDataList()), getProductItems(productItemCount));
        return p;
    }
}
