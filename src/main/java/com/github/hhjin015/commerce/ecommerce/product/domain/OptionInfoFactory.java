package com.github.hhjin015.commerce.ecommerce.product.domain;

import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionCombinationRequest;
import com.github.hhjin015.commerce.ecommerce.product.request.CreateOptionRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OptionInfoFactory {

    private final OptionFactory optionFactory;
    private final OptionCombinationFactory optionCombinationFactory;

    public OptionInfo createBy(List<CreateOptionRequest> optionRequests, List<CreateOptionCombinationRequest> optionCombinationRequests) {
        List<Option> options = new ArrayList<>();
        List<OptionCombination> optionCombinations = new ArrayList<>();

        for (CreateOptionRequest req : optionRequests) {
            options.add(optionFactory.createBy(req));
        }

        for(CreateOptionCombinationRequest req : optionCombinationRequests) {
            optionCombinations.add(optionCombinationFactory.createBy(req));
        }

        return new OptionInfo(options, optionCombinations);
    }
}
