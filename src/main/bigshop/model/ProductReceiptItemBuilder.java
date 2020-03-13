package main.bigshop.model;

import java.math.BigDecimal;

public class ProductReceiptItemBuilder {

    private Product product;
    private BigDecimal tax;
    private Money finalPrice;

    public ProductReceiptItemBuilder withProduct(final Product product){
        this.product = product;
        return this;
    }

    public ProductReceiptItemBuilder withTax(final BigDecimal tax){
        this.tax = tax;
        return this;
    }

    public ProductReceiptItemBuilder withFinalPrice(final Money finalPrice){
        this.finalPrice = finalPrice;
        return this;
    }

    public ProductReceiptItem build(){
        return new ProductReceiptItem(product, finalPrice, tax);
    }
}
