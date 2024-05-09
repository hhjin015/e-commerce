package com.github.hhjin015.commerce.ecommerce.product.service;

import com.github.hhjin015.commerce.ecommerce.product.domain.option.Option;
import com.github.hhjin015.commerce.ecommerce.product.domain.option.OptionFactory;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.Product;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductId;
import com.github.hhjin015.commerce.ecommerce.product.domain.product.ProductRepository;
import com.github.hhjin015.commerce.ecommerce.product.mapper.StatusMapper;
import com.github.hhjin015.commerce.ecommerce.product.service.data.ModifyProductData;
import com.github.hhjin015.commerce.ecommerce.product.service.data.OptionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final OptionFactory optionFactory;

    public void modifyProduct(String id, ModifyProductData data) {
        Optional<Product> optP = productRepository.findBy(ProductId.of(id));
        if (optP.isEmpty()) throw new NoSuchElementException("해당 상품이 존재하지 않습니다.");

        Product p = optP.get();
        p.update(
                isNull(data.getName()) ? p.getName() : data.getName(),
                isNull(data.getDescription()) ? p.getDescription() : data.getDescription(),
                data.getPrice() == 0 ? p.getPrice() : data.getPrice(),
                isNull(data.getOptionsData()) ? p.getOptions() : generateOption(data.getOptionsData()),
                isNull(data.getStatus()) ? p.getSalesStatus() : StatusMapper.INSTANCE.toProductSalesStatus(data.getStatus())
        );

        productRepository.save(p);
    }

    private List<Option> generateOption(List<OptionData> optionData) {
        return optionData.stream()
                .map(optionFactory::createBy)
                .collect(Collectors.toList());
    }
}
