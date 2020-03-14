package main.bigshop;

import main.bigshop.model.*;
import main.bigshop.util.ProductUtil;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateReceipt {
    private final Set<Product> products;
    private final CalculationStrategyFactory factory;

    public GenerateReceipt() {
        products = ProductUtil.initProductSet();
        factory = new CalculationStrategyFactory();
    }

    public Receipt generateReceipt(final List<String> items) throws Exception {
        final ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        final List<Product> productList = items.stream()
                .map(item -> getProduct(item, products))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .collect(Collectors.toList());

        final long simCardsCount =
                productList.stream().filter(productItem ->
                        ProductCategory.SIM_CARD == productItem.getCategory()).count();
        if(simCardsCount * 2 >= ProductUtil.MAX_SIM_CARDS_ALLOWED){
            throw new Exception("Maxim 10 Sim cards allowed");
        }
        productList.forEach(product -> {
            final CalculationStrategy interestCalculationStrategy =
                    factory.getInterestCalculationStrategy(product.getProductType());
            try {
                final List<ReceiptItem> receiptItems = interestCalculationStrategy.calculate(product, productList);
                receiptBuilder.addAllReceiptItems(receiptItems);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        });

        return receiptBuilder.build();
    }

    public Optional<Product> getProduct(final String name, final Set<Product> products) {
        return products.stream().filter(prod -> name.equals(prod.getName())).findFirst();
    }
}
