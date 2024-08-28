package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}