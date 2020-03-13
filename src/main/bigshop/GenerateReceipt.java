package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductHelper;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateReceipt {
    private final Set<Product> products;
    private final CalculationStrategyFactory factory;

    public GenerateReceipt() {
        products = ProductHelper.initProductSet();
        factory = new CalculationStrategyFactory();
    }

    public Receipt generateReceipt(final List<String> items) throws Exception {
        final ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        final List<Product> productList = items.stream()
                .map(item -> getProduct(item, products))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .collect(Collectors.toList());
        final Boolean isEarphoneInBasket = productList.stream().anyMatch(productItem ->
                ProductCategory.WIRED_EARPHONES == productItem.getCategory() ||
                        ProductCategory.WIRELESS_EARPHONES == productItem.getCategory());

        productList.forEach(product -> {
                final InterestCalculationStrategy interestCalculationStrategy =
                        factory.getInterestCalculationStrategy(product.getProductType());
                try {
                    interestCalculationStrategy.calculate(receiptBuilder, product, isEarphoneInBasket);
                } catch (Exception e) {
                    throw new RuntimeException(e);
            }
        });

        return receiptBuilder.build();
    }

    public Optional<Product> getProduct(final String name, final Set<Product> products){
        return products.stream().filter(prod -> name.equals(prod.getName())).findFirst();
    }
}
