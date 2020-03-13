package main.bigshop.model;

public class ProductBuilder {

    private ProductCategory category;
    private String name;
    private ProductType productType;
    private Money price;

    public ProductBuilder withCategory(final ProductCategory category){
        this.category = category;
        return this;
    }

    public ProductBuilder withName(final String name){
        this.name = name;
        return this;
    }

    public ProductBuilder withProductType(final ProductType productType){
        this.productType = productType;
        return this;
    }

    public ProductBuilder withPrice(final Money price){
        this.price = price;
        return this;
    }

    public Product build(){
        return new Product(category, name, price, productType);
    }
}
