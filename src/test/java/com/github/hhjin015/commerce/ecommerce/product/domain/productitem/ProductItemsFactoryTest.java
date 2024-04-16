package com.github.hhjin015.commerce.ecommerce.product.domain.productitem;

import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionCombinationData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductItemData;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionCombinationFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductItemsFactoryTest {

    ProductItemsFactory sut = new ProductItemsFactory(new OptionCombinationFactory());

    public static final ProductId ANY_ID = ProductId.of("ID");
    public static final Product PRODUCT_WITH_OPTION = getProduct(1000, getOptions());
    public static final Product PRODUCT_WITHOUT_OPTION = getProduct(2000, null);
    public static final OptionCombinationData OPTION_COMBINATION_DATA = getOptionCombinationData(1000);
    public static final ProductItemData PRODUCT_ITEM_DATA_WITH_OPTIONCOMB = new ProductItemData(0, OPTION_COMBINATION_DATA);
    public static final ProductItemData PRODUCT_ITEM_DATA_WITHOUT_OPTIONCOMB = new ProductItemData(20, null);

    @Test
    @DisplayName("옵션을 사용하지 않을 경우, Product의 가격이 ProductItem의 가격이 된다.")
    void calcSalePriceWithoutOption() {
        List<ProductItem> actual = sut.createBy(List.of(PRODUCT_ITEM_DATA_WITHOUT_OPTIONCOMB), PRODUCT_WITHOUT_OPTION);
        assertThat(actual.get(0).getSalePrice()).isEqualTo(PRODUCT_WITHOUT_OPTION.getPrice());
    }

    @Test
    @DisplayName("옵션을 사용할 경우, Product의 price와 OptionCombinationData의 additionalPrice를 더한 값이 ProductItem의 가격이 된다.")
    void calcSalePriceWithOption() {
        List<ProductItem> actual = sut.createBy(List.of(PRODUCT_ITEM_DATA_WITH_OPTIONCOMB), PRODUCT_WITH_OPTION);
        assertThat(actual.get(0).getSalePrice()).isEqualTo(PRODUCT_WITH_OPTION.getPrice() + OPTION_COMBINATION_DATA.getAdditionalPrice());
    }

    private static OptionCombinationData getOptionCombinationData(int additionalPrice) {
        return new OptionCombinationData(List.of("S", "red"), additionalPrice);
    }

    private static List<Option> getOptions() {
        return List.of(
                Option.of("size", List.of("S, M")),
                Option.of("color", List.of("red, blue"))
        );
    }

    private static Product getProduct(int price, List<Option> options) {
        return new Product(ANY_ID, "양말", "양말 사세요", price, options);
    }
}