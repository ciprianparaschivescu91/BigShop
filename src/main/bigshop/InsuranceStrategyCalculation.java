package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InsuranceStrategyCalculation implements CalculationStrategy {

    @Override
    public List<ReceiptItem> calculate(final Product product, final List<Product> products) {
        final InsuranceReceiptItemBuilder item = new InsuranceReceiptItemBuilder();
        final Boolean isEarphoneInBasket = products.stream().anyMatch(productItem ->
                ProductCategory.WIRED_EARPHONES == productItem.getCategory() ||
                        ProductCategory.WIRELESS_EARPHONES == productItem.getCategory());
        item.withProduct(product);
        if(isEarphoneInBasket){
            final BigDecimal discount = ProductUtil.DISCOUNT.multiply(product.getPrice().getAmount());
            item.withDiscount(discount);
            item.withFinalPrice(isEarphoneInBasket ?
                    new Money(product.getPrice().getAmount().subtract(discount), product.getPrice().getCurrency()) : product.getPrice());
        } else {
            item.withDiscount(BigDecimal.ZERO);
            item.withFinalPrice(product.getPrice());
        }

        return Arrays.asList(item.build());
    }
}
