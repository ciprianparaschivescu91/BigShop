package main.bigshop.model;

public enum ProductCategory {

    SIM_CARD("SIM card"),
    PHONE_CASE("phone case"),
    PHONE_INSURANCE("phone insurance"),
    WIRED_EARPHONES("wired earphones"),
    WIRELESS_EARPHONES("wireless earphones");

    private final String name;

    ProductCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
