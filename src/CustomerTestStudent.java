import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTestStudent {
    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Lara", 30);
        Customer copy = new Customer(original);
        assertEquals("Lara", copy.getName());
        assertEquals(30, copy.getAge());
    }

    @Test
    public void testSetters() {
        Customer c = new Customer("Temp", 20);
        c.setName("Max");
        c.setAge(22);
        assertEquals("Max", c.getName());
        assertEquals(22, c.getAge());
    }
}
