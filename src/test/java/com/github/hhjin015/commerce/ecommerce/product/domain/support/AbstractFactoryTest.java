package com.github.hhjin015.commerce.ecommerce.product.domain.support;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombination;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItemId;
import com.github.hhjin015.commerce.ecommerce.product.service.data.*;

import java.util.List;

public abstract class AbstractFactoryTest {

    public static final int DEFAULT_PRICE = 1000;
    public static final int ADDITIONAL_PRICE = 2000;
    public static final int SALE_PRICE = DEFAULT_PRICE + ADDITIONAL_PRICE;
    public static final ProductItemsData PRODUCT_ITEMS_DATA_WITH_OPTION = getProductItemsDataWithOption();
    public static final ProductItemsData PRODUCT_ITEMS_DATA_WITHOUT_OPTION = getProductItemsDataWithoutOption();
    public static final int ANY_QUANTITY = 10;

    protected static List<OptionData> getOptionData() {
        return List.of(
                new OptionData("size", List.of("s, m")),
                new OptionData("color", List.of("red", "blue"))
        );
    }

    protected static ProductData getProductData(List<OptionData> optionData) {
        return new ProductData("양말", "양말 사세요", DEFAULT_PRICE, optionData);
    }

    protected static List<ProductItem> getProductItems(OptionCombination optionCombination) {
        return List.of(new ProductItem(ProductItemId.of("ID"), SALE_PRICE, ANY_QUANTITY, optionCombination));
    }

    protected static OptionCombination getOptionCombination() {
        return OptionCombination.of(List.of("s", "red"), ADDITIONAL_PRICE);
    }

    protected static ProductItemsData getProductItemsDataWithOption() {
        return new ProductItemsData(
                List.of(getProductItemData(), getProductItemData()),
                true,
                DEFAULT_PRICE
        );
    }

    protected static ProductItemsData getProductItemsDataWithoutOption() {
        return new ProductItemsData(
                List.of(new ProductItemData(ANY_QUANTITY, null)),
                false,
                DEFAULT_PRICE
        );
    }

    protected static ProductItemData getProductItemData() {
        return new ProductItemData(ANY_QUANTITY, getOptionCombinationData());
    }

    protected static OptionCombinationData getOptionCombinationData() {
        return new OptionCombinationData(List.of("S", "red"), ADDITIONAL_PRICE);
    }
}
