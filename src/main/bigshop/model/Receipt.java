package main.bigshop.model;

import java.util.List;

public class Receipt {

    private final List<ReceiptItem> items;
    private final Money total;

    Receipt(final List<ReceiptItem> items, final Money total) {
        this.items =  items;
        this.total = total;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public Money getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (items != null ? !items.equals(receipt.items) : receipt.items != null) return false;
        return total != null ? total.equals(receipt.total) : receipt.total == null;
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "main.bigshop.model.Receipt{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
