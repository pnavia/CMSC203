import static org.junit.Assert.*;
import org.junit.Test;

public class SmoothieTestStudent {

    @Test
    public void testCalcPriceWithProtein() {
        // Expected price: 2.0 (base) + 1.0 (LARGE) + 1.5 (3 fruits) + 1.5 (protein) = 6.0
        Smoothie s = new Smoothie("Berry", Size.LARGE, 3, true);
        assertEquals(6.0, s.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPriceWithoutProtein() {
        // Expected price: 2.0 (base) + 0.5 (MEDIUM) + 1.0 (2 fruits) + 0.0 (no protein) = 3.5
        Smoothie s = new Smoothie("Mango", Size.MEDIUM, 2, false);
        assertEquals(3.5, s.calcPrice(), 0.001);
    }
}
