package main.bigshop.model;

public abstract class ReceiptItem {

    private final Product product;
    private final Money finalPrice;

    ReceiptItem(final Product product, final Money finalPrice) {
        this.product = product;
        this.finalPrice = finalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Money getFinalPrice() {
        return finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptItem that = (ReceiptItem) o;

        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return finalPrice != null ? finalPrice.equals(that.finalPrice) : that.finalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (finalPrice != null ? finalPrice.hashCode() : 0);
        return result;
    }
}
