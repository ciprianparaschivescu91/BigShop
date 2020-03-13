package main.bigshop;

import main.bigshop.model.Receipt;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final GenerateReceipt printReceipt = new GenerateReceipt();
        try {
            final Receipt receipt = printReceipt.generateReceipt(Arrays.asList(
                    "SIM card", "phone insurance", "wired earphones", "SIM card"));
            print(receipt);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    static void print(final Receipt receipt){
        receipt.getItems().forEach(System.out :: println);
        System.out.println("Total: "+ receipt.getTotal());
    }
}
