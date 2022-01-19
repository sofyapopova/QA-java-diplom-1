package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockedTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceReturnsCorrectValue() {

        float expectedBurgerPrice = 600;

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        float actualBurgerPrice = burger.getPrice();

        assertEquals("getPrice method returns incorrect value", expectedBurgerPrice, actualBurgerPrice, 1e-16);
    }

    @Test
    public void getReceiptReturnsCorrectValue() {

        String expectedReceipt = String.format("(==== Bulochka ====)%n" +
                "= filling sochnayaKotleta =%n" +
                "= filling sochnayaKotleta =%n" +
                "(==== Bulochka ====)%n" +
                "%nPrice: 600,000000%n");

        Mockito.when(bun.getName()).thenReturn("Bulochka");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("sochnayaKotleta");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        String actualReceipt = burger.getReceipt();

        assertEquals("getReceipt method return incorrect value", expectedReceipt, actualReceipt);
    }
}
