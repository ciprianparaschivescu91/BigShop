package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductHelper;

import java.math.BigDecimal;

public class ProductStrategyCalculation implements InterestCalculationStrategy {

    private final Integer MAX_SIM_CARDS_ALLOWED = 10;

    @Override
    public void calculate(final ReceiptBuilder receiptBuilder,
                          final Product product, final Boolean isEarphoneInBasket) throws Exception {
        final BigDecimal tax = ProductHelper.SALES_TAX.multiply(product.getPrice().getAmount());
        if(ProductCategory.SIM_CARD == product.getCategory()){
            final long simCardsCount =
                    receiptBuilder.getItems().stream().filter(receiptItem ->
                            ProductCategory.SIM_CARD == receiptItem.getProduct().getCategory()).count();
            if(simCardsCount >= MAX_SIM_CARDS_ALLOWED){
                throw new Exception("Maxim 10 Sim cards allowed");
            }
            receiptBuilder.addItem(new ProductReceiptItemBuilder()
                    .withProduct(product)
                    .withTax(BigDecimal.ZERO)
                    .withFinalPrice(new Money(BigDecimal.ZERO, product.getPrice().getCurrency()))
                    .build());
        }

        receiptBuilder.addItem(new ProductReceiptItemBuilder()
                .withProduct(product)
                .withTax(tax)
                .withFinalPrice(new Money(product.getPrice().getAmount().add(tax), product.getPrice().getCurrency()))
                .build());
    }
}
