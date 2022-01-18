package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    private String expectedName;
    private float expectedPrice;

    @Before
    public void setUp() {
        expectedName = "sochnayaKotleta";
        expectedPrice = 123;
        ingredient = new Ingredient(IngredientType.FILLING, expectedName, expectedPrice);
    }

    @Test
    public void getPriceReturnsCorrectValue() {

        float actualPrice = ingredient.getPrice();
        assertEquals("getPrice method returns incorrect value", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getNameReturnsCorrectValue() {

        String actualName = ingredient.getName();
        assertEquals("getName method returns incorrect value", expectedName, actualName);
    }
}