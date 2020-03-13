package main.bigshop;

import main.bigshop.model.Product;
import main.bigshop.model.ReceiptBuilder;

public interface CalculationStrategy {

    void calculate(final ReceiptBuilder receiptBuilder, final Product product, Boolean isEarphoneInBasket) throws Exception;

}
