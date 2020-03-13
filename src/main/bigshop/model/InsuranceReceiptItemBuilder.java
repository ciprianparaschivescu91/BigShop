package main.bigshop.model;

import java.math.BigDecimal;

public class InsuranceReceiptItemBuilder {

    private Product product;
    private BigDecimal discount;
    private Money finalPrice;

    public InsuranceReceiptItemBuilder withProduct(final Product product){
        this.product = product;
        return this;
    }

    public InsuranceReceiptItemBuilder withDiscount(final BigDecimal discount){
        this.discount = discount;
        return this;
    }

    public InsuranceReceiptItemBuilder withFinalPrice(final Money finalPrice){
        this.finalPrice = finalPrice;
        return this;
    }

    public InsuranceReceiptItem build(){
        return new InsuranceReceiptItem(product, finalPrice, discount);
    }
}
