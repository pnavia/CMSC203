import static org.junit.Assert.*;
import org.junit.Test;

public class OrderTestStudent {

    @Test
    public void testAddCoffeeToOrder() {
        Customer cust = new Customer("Sam", 20);
        Order o = new Order(10, Day.TUESDAY, cust);
        o.addNewBeverage("Latte", Size.SMALL, true, false);
        assertEquals(1, o.getTotalItems());
    }

    @Test
    public void testCalcOrderTotal() {
        Customer cust = new Customer("Nina", 22);
        Order o = new Order(12, Day.FRIDAY, cust);
        o.addNewBeverage("Latte", Size.SMALL, false, false);
        o.addNewBeverage("Beer", Size.SMALL);
        assertTrue(o.calcOrderTotal() >= 4.0);
    }
}
