package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

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
    public void setBunsCanBeCalled() {

        Burger spyBurger = Mockito.spy(burger);

        spyBurger.setBuns(bun);
        Mockito.verify(spyBurger).setBuns(bun);
    }

    @Test
    public void addIngredientWorksCorrect() {

        burger.addIngredient(ingredient);

        assertTrue("addIngredient method works incorrect", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientWorksCorrect() {

        burger.ingredients.add(ingredient);

        burger.removeIngredient((burger.ingredients.lastIndexOf(ingredient)));

        assertFalse("removeIngredient method works incorrect", burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientWorksCorrect() {

        Ingredient extraIngredient = Mockito.mock(Ingredient.class);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(extraIngredient);

        burger.moveIngredient(0, 1);

        assertEquals("moveIngredient method works incorrect", burger.ingredients.get(0), extraIngredient);
        assertEquals("moveIngredient method works incorrect", burger.ingredients.get(1), ingredient);
    }

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
