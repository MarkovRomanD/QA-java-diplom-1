package praktikum;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    public Bun getBun() {
        when(bun.getName()).thenReturn("black");
        when(bun.getPrice()).thenReturn(99f);
        return bun;
    }

    public Ingredient getFirstIngredient() {
        when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientOne.getName()).thenReturn("my hot sauce");
        when(ingredientOne.getPrice()).thenReturn(12f);
        return ingredientOne;
    }

    public Ingredient getSecondIngredient() {
        when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientTwo.getName()).thenReturn("mega cutlet");
        when(ingredientTwo.getPrice()).thenReturn(35f);
        return ingredientTwo;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun bunExpected = getBun();
        burger.setBuns(bunExpected);
        Assert.assertEquals(bunExpected, burger.bun);

    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredientExpected = getFirstIngredient();
        burger.addIngredient(ingredientExpected);
        Assert.assertEquals(ingredientExpected, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getFirstIngredient();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = getFirstIngredient();
        Ingredient secondIngredient = getSecondIngredient();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Bun testBun = getBun();
        Ingredient firstIngredient = getFirstIngredient();
        Ingredient secondIngredient = getSecondIngredient();
        burger.setBuns(testBun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float actual = burger.getPrice();
        Assert.assertEquals(245f, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun testBun = getBun();
        Ingredient firstIngredient = getFirstIngredient();
        Ingredient secondIngredient = getSecondIngredient();
        burger.setBuns(testBun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String actual = burger.getReceipt();
        String expected = String.format("(==== black ====)%n" +
                "= sauce my hot sauce =%n" +
                "= filling mega cutlet =%n" +
                "(==== black ====)%n" +
                "%n" +
                "Price: 245,000000%n");
        Assert.assertEquals(expected, actual);
    }

}