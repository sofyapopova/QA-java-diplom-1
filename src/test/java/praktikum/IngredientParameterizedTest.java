package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType ingredientType;

    public IngredientParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] getIngredientTypeData() {
        return new Object[][]{
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(ingredientType, "sochnayaKotleta", 123);

        IngredientType actualIngredientType = ingredient.getType();

        assertEquals("getType method returns incorrect value", ingredientType, actualIngredientType);
    }
}