package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
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

    public void modifyProduct(String id, ModifyProductData data) {
        Product product = productRepository.findBy(ProductId.of(id));

        product.update(
                isNull(data.getName()) ? product.getName() : data.getName(),
                isNull(data.getDescription()) ? product.getDescription() : data.getDescription(),
                data.getPrice() == 0 ? product.getPrice() : data.getPrice(),
                isNull(data.getOptionsData()) ? product.getOptions() : parseOptionData(data.getOptionsData())
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
