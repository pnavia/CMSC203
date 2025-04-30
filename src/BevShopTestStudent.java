import static org.junit.Assert.*;
import org.junit.Test;

public class BevShopTestStudent {

    @Test
    public void testStartNewOrderAndTotal() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "Alex", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(2.5, shop.getCurrentOrder().calcOrderTotal(), 0.001);
    }

    @Test
    public void testValidAge() {
        BevShop shop = new BevShop();
        assertTrue(shop.validAge(21));
        assertFalse(shop.validAge(17));
    }
}
