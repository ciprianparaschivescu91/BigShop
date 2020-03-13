package main.bigshop.model;

import main.bigshop.util.ProductHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ReceiptBuilder {

    private List<ReceiptItem> items;
    private Money total;

    public ReceiptBuilder() {
        this.items = new ArrayList<>();
        this.total = new Money(BigDecimal.ZERO, Currency.getInstance(ProductHelper.CURRENCY_CHF));
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public Money getTotal() {
        return total;
    }

    public ReceiptBuilder addItem(final ReceiptItem item){
        this.items.add(item);
        total = new Money(total.getAmount().add(item.getFinalPrice().getAmount()), total.getCurrency());
        return this;
    }

    public Receipt build(){
        return new Receipt(items, total);
    }
}
