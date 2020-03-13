package main.bigshop.util;

import main.bigshop.model.*;

import java.math.BigDecimal;
import java.util.*;

public class ProductHelper {

    public static final BigDecimal DISCOUNT = new BigDecimal(0.2).setScale(2, BigDecimal.ROUND_HALF_UP);
    public static final BigDecimal SALES_TAX = new BigDecimal(0.12).setScale(2, BigDecimal.ROUND_HALF_UP);
    public static final String CURRENCY_CHF = "CHF";

    public static Set<Product> initProductSet(){
        final Set<Product> products = new HashSet<>();
        final Product simCardProduct = new ProductBuilder()
                .withCategory(ProductCategory.SIM_CARD)
                .withProductType(ProductType.PRODUCT)
                .withName("SIM card")
                .withPrice(new Money(new BigDecimal(20), Currency.getInstance(CURRENCY_CHF)))
                .build();

        final Product phoneCaseProduct = new ProductBuilder()
                .withCategory(ProductCategory.PHONE_CASE)
                .withProductType(ProductType.PRODUCT)
                .withName("phone case")
                .withPrice(new Money(new BigDecimal(10), Currency.getInstance(CURRENCY_CHF)))
                .build();

        final Product phoneInsuranceProduct = new ProductBuilder()
                .withCategory(ProductCategory.PHONE_INSURANCE)
                .withProductType(ProductType.INSURANCE)
                .withName("phone insurance")
                .withPrice(new Money(new BigDecimal(120), Currency.getInstance(CURRENCY_CHF)))
                .build();

        final Product wiredEarphonesProduct = new ProductBuilder()
                .withCategory(ProductCategory.WIRED_EARPHONES)
                .withProductType(ProductType.PRODUCT)
                .withName("wired earphones")
                .withPrice(new Money(new BigDecimal(30), Currency.getInstance(CURRENCY_CHF)))
                .build();

        final Product wirelessEarphonesProduct = new ProductBuilder()
                .withCategory(ProductCategory.WIRELESS_EARPHONES)
                .withProductType(ProductType.PRODUCT)
                .withName("wireless earphones")
                .withPrice(new Money(new BigDecimal(50), Currency.getInstance(CURRENCY_CHF)))
                .build();

        products.add(simCardProduct);
        products.add(phoneCaseProduct);
        products.add(phoneInsuranceProduct);
        products.add(wiredEarphonesProduct);
        products.add(wirelessEarphonesProduct);
        return products;
    }
}
