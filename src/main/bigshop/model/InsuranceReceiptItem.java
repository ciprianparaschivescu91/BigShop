package main.bigshop.model;

import java.math.BigDecimal;

public class InsuranceReceiptItem extends ReceiptItem {

    private final BigDecimal discount;

    InsuranceReceiptItem(final Product product, final Money finalPrice, final BigDecimal discount) {
        super(product, finalPrice);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InsuranceReceiptItem that = (InsuranceReceiptItem) o;

        return discount != null ? discount.equals(that.discount) : that.discount == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product: " + getProduct().getName() + " ,Discount: " + discount + " ,Final Price: " + getFinalPrice();
    }
}
