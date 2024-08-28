package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParam() {
        return new Object[][]{
                {SAUCE, "hot chili sauce", 34f},
                {FILLING, "mega super cutlet", 99f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }


    @Test
    public void getPriceTest() {
        assertEquals(price,ingredient.getPrice(),0.00f);
    }
    @Test
    public void getNameTest() {
        assertEquals(name,ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        assertEquals(type,ingredient.getType());
    }

}