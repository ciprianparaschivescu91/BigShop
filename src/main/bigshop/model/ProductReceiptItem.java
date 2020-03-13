package main.bigshop.model;

import java.math.BigDecimal;

public class ProductReceiptItem extends ReceiptItem{

    private final BigDecimal tax;

    ProductReceiptItem(final Product product, final Money finalPrice, final BigDecimal tax) {
        super(product, finalPrice);
        this.tax = tax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProductReceiptItem that = (ProductReceiptItem) o;

        return tax != null ? tax.equals(that.tax) : that.tax == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product: " + getProduct().getName() + " ,Tax: " + tax + " ,Final Price: " + getFinalPrice();
    }
}
