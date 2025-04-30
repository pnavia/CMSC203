import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeTestStudent {
    @Test
    public void testCalcPrice() {
        Coffee c = new Coffee("Cappuccino", Size.MEDIUM, true, true);
        assertEquals(3.5, c.calcPrice(), 0.001);
    }

    @Test
    public void testToStringContainsDetails() {
        Coffee c = new Coffee("Mocha", Size.SMALL, true, false);
        String output = c.toString();
        assertTrue(output.contains("Mocha"));
        assertTrue(output.contains("Extra Shot: true"));
    }
}