package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductHelper;

import java.math.BigDecimal;

public class InsuranceStrategyCalculation implements CalculationStrategy {

    @Override
    public void calculate(final ReceiptBuilder receiptBuilder, final Product product, Boolean isEarphoneInBasket) {
        final BigDecimal discount = ProductHelper.DISCOUNT.multiply(product.getPrice().getAmount());

        final InsuranceReceiptItemBuilder item = new InsuranceReceiptItemBuilder();
        item.withProduct(product);
        if(isEarphoneInBasket){
            item.withDiscount(discount);
            item.withFinalPrice(isEarphoneInBasket ?
                    new Money(product.getPrice().getAmount().subtract(discount), product.getPrice().getCurrency()) : product.getPrice());
        } else {
            item.withDiscount(BigDecimal.ZERO);
            item.withFinalPrice(product.getPrice());
        }

        receiptBuilder.addItem(item.build());
    }
}
