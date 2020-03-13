package test;

import main.bigshop.GenerateReceipt;
import main.bigshop.model.Receipt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class GenerateReceiptTest {

    private GenerateReceipt generateReceipt;

    @Before
    public void setup(){
        generateReceipt = new GenerateReceipt();
    }

    @Test
    public void shouldReturnCorrectAmountWithNoDiscount() throws Exception {
        final Receipt receipt = generateReceipt.generateReceipt(Arrays.asList( "SIM card", "phone insurance", "phone case"));
        Assert.assertEquals(receipt.getTotal().getAmount(), new BigDecimal(153.60).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void shouldReturnCorrectAmountWithDiscount() throws Exception {
        final Receipt receipt = generateReceipt.generateReceipt(Arrays.asList( "SIM card", "phone insurance", "wired earphones"));
        Assert.assertEquals(receipt.getTotal().getAmount(), new BigDecimal(152.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void shouldReturnCorrectSimCards() throws Exception {
        final Receipt receipt = generateReceipt.generateReceipt(Arrays.asList( "SIM card", "SIM card", "phone insurance", "wired earphones"));
        Assert.assertEquals(receipt.getItems().size(), 6);
    }

    @Test
    public void shouldReturnOnlyTheExistingProducts() throws Exception {
        final Receipt receipt = generateReceipt.generateReceipt(Arrays.asList( "wired earphones_2", "phone insurance", "phone case"));
        Assert.assertEquals(receipt.getItems().size(), 2);
    }

    @Test(expected = Exception.class)
    public void testExecuteWithMoreThanFiveSimCards() throws Exception {
         generateReceipt.generateReceipt(Arrays.asList( "SIM card", "SIM card", "phone insurance", "wired earphones",
                "SIM card", "SIM card", "SIM card", "SIM card"));
    }
}
