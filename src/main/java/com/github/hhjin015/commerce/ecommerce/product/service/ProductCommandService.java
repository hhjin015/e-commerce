package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.OptionData;
import com.github.hhjin015.commerce.ecommerce.product.service.datas.ProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final OptionFactory optionFactory;

    public void modifyProduct(String id, ProductData productData) {
        Product product = productRepository.findBy(ProductId.of(id));

        product.update(
                isNull(productData.getName()) ? product.getName() : productData.getName(),
                isNull(productData.getDescription()) ? product.getDescription() : productData.getDescription(),
                productData.getPrice() == 0 ? product.getPrice() : productData.getPrice(),
                isNull(productData.getOptionsData()) ? product.getOptions() : parseOptionData(productData.getOptionsData())
        );

        productRepository.save(product);
    }

    private List<Option> parseOptionData(List<OptionData> optionData) {
        List<Option> options = new ArrayList<>();

        for(OptionData op : optionData) {
            options.add(optionFactory.createBy(op));
        }

        return options;
    }
}
