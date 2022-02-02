package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    private String expectedName;
    private float expectedPrice;

    @Before
    public void setUp() {

        expectedName = "bulochka";
        expectedPrice = 124;

        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void getNameReturnsCorrectValue() {

        String actualName = bun.getName();
        assertEquals("getName method returns incorrect value", expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectValue() {

        float actualPrice = bun.getPrice();
        assertEquals("getPrice method returns incorrect value", expectedPrice, actualPrice, 1e-16);
    }
}