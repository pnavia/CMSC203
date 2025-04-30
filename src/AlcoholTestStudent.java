import static org.junit.Assert.*;
import org.junit.Test;

public class AlcoholTestStudent {
    @Test
    public void testCalcPriceWeekend() {
        Alcohol drink = new Alcohol("Beer", Size.LARGE, true);
        assertEquals(3.6, drink.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPriceWeekday() {
        Alcohol drink = new Alcohol("Wine", Size.SMALL, false);
        assertEquals(2.0, drink.calcPrice(), 0.001);
    }
}