package com.github.hhjin015.commerce.ecommerce.product.domain.product;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.productitem.ProductItem;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ProductData;
import com.github.hhjin015.commerce.ecommerce.product.domain.support.AbstractFactoryTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductFactoryTest extends AbstractFactoryTest {

    public static final ProductData PRODUCT_DATA_WITHOUT_OPTION = getProductData(null);
    public static final ProductData PRODUCT_DATA_WITH_OPTION = getProductData(getOptionDataList());
    public static final List<ProductItem> PRODUCT_ITEMS_WITHOUT_OPTION_COMBINATION = getProductItems(null);
    public static final List<ProductItem> PRODUCT_ITEMS_WITH_OPTION_COMBINATION = getProductItems(getOptionCombination());

    ProductFactory sut = new ProductFactory(new OptionFactory());

    @Test
    @DisplayName("옵션 없는 상품 생성")
    void createProductWithOption() {
        Product actual = sut.createBy(PRODUCT_DATA_WITHOUT_OPTION, PRODUCT_ITEMS_WITHOUT_OPTION_COMBINATION);
        assertThat(actual).isNotNull();
        assertThat(actual.getOptions()).isNull();
    }

    @Test
    @DisplayName("옵션 있는 상품 생성")
    void createProductWithoutOption() {
        Product actual = sut.createBy(PRODUCT_DATA_WITH_OPTION, PRODUCT_ITEMS_WITH_OPTION_COMBINATION);
        assertThat(actual).isNotNull();
        assertThat(actual.getOptions()).isNotNull();
        assertThat(actual.getProductItems()).isNotNull();
    }
}