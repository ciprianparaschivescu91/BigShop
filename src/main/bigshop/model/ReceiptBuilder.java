package main.bigshop.model;

import main.bigshop.util.ProductUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ReceiptBuilder {

    private List<ReceiptItem> receiptItems;
    private Money total;

    public ReceiptBuilder() {
        this.receiptItems = new ArrayList<>();
        this.total = new Money(BigDecimal.ZERO, Currency.getInstance(ProductUtil.CURRENCY_CHF));
    }

    public List<ReceiptItem> getItems() {
        return receiptItems;
    }

    public Money getTotal() {
        return total;
    }

    public ReceiptBuilder addReceiptItem(final ReceiptItem item){
        this.receiptItems.add(item);
        total = new Money(total.getAmount().add(item.getFinalPrice().getAmount()), total.getCurrency());
        return this;
    }

    public ReceiptBuilder addAllReceiptItems(final List<ReceiptItem> items){
        items.forEach(receiptItem -> addReceiptItem(receiptItem));
        return this;
    }

    public Receipt build(){
        return new Receipt(receiptItems, total);
    }
}
