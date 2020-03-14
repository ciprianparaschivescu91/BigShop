package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductStrategyCalculation implements CalculationStrategy {

    @Override
    public List<ReceiptItem> calculate(final Product product, final List<Product> products) {
        final List<ReceiptItem> response = new ArrayList<>();
        final BigDecimal tax = ProductUtil.SALES_TAX.multiply(product.getPrice().getAmount());
        response.add(new ProductReceiptItemBuilder()
                .withProduct(product)
                .withTax(tax)
                .withFinalPrice(new Money(product.getPrice().getAmount().add(tax), product.getPrice().getCurrency()))
                .build());
        if(ProductCategory.SIM_CARD == product.getCategory()){
            response.add(new ProductReceiptItemBuilder()
                    .withProduct(product)
                    .withTax(BigDecimal.ZERO)
                    .withFinalPrice(new Money(BigDecimal.ZERO, product.getPrice().getCurrency()))
                    .build());
        }
        return response;
    }
}
