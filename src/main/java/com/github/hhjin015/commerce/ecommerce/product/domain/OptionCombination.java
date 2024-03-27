package com.github.hhjin015.commerce.ecommerce.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OptionCombination {
    private List<String> optionNames;
    private int price;
    private int quantity;
    private SalesStatus salesStatus;

    public OptionCombination(List<String> optionNames, int price, int quantity) {
        this.optionNames = optionNames;
        this.price = price;
        this.quantity = quantity;

        // 둘 중 무엇
//        changeSalesStatus1();
        this.salesStatus = changeSalesStatus2();
    }

    private void changeSalesStatus1() {
        if(this.quantity <= 0) {
            this.salesStatus = SalesStatus.SOLD_OUT;
        } else {
            this.salesStatus = SalesStatus.ON_SALE;
        }
    }

    private SalesStatus changeSalesStatus2() {
        if(this.quantity <= 0) return SalesStatus.SOLD_OUT;
        else return SalesStatus.ON_SALE;
    }
}
