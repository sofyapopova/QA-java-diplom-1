package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    private Burger burger;

    private Database database;

    private Bun bun;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();

        database = new Database();
    }

    @Test
    public void setBunsWorksCorrect() {
        bun = database.availableBuns().get(0);

        String expectedBunName = bun.name;
        float expectedBunPrice = bun.price;

        burger.setBuns(bun);

        String actualBunName = burger.bun.name;
        float actualBunPrice = burger.bun.price;

        assertEquals("setBuns method works incorrect", expectedBunName, actualBunName);
        assertEquals("setBuns method works incorrect", expectedBunPrice, actualBunPrice, 1e-16);
    }

    @Test
    public void addIngredientWorksCorrect() {
        ingredient = database.availableIngredients().get(0);

        burger.addIngredient(ingredient);

        assertTrue("addIngredient method works incorrect", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientWorksCorrect() {
        ingredient = database.availableIngredients().get(0);
        burger.ingredients.add(ingredient);

        burger.removeIngredient((burger.ingredients.lastIndexOf(ingredient)));

        assertFalse("removeIngredient method works incorrect", burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientWorksCorrect() {
        ingredient = database.availableIngredients().get(0);
        Ingredient extraIngredient = database.availableIngredients().get(1);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(extraIngredient);

        burger.moveIngredient(0, 1);

        assertEquals("moveIngredient method works incorrect", burger.ingredients.get(0), extraIngredient);
        assertEquals("moveIngredient method works incorrect", burger.ingredients.get(1), ingredient);
    }
}