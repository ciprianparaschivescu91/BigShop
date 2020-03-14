package main.bigshop;

import main.bigshop.model.Product;
import main.bigshop.model.ReceiptItem;

import java.util.List;

public interface CalculationStrategy {

    List<ReceiptItem> calculate(final Product product, final List<Product> products);

}
