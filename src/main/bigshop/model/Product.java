package main.bigshop.model;

public class Product {

    private final ProductCategory category;
    private final String name;
    private final Money price;
    private final ProductType productType;

    Product(final ProductCategory category, final String name, final Money price, final ProductType productType){
        this.category = category;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Money getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (category != product.category) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        return productType == product.productType;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        return result;
    }
}
