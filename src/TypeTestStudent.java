import static org.junit.Assert.*;
import org.junit.Test;

public class TypeTestStudent {
    @Test
    public void testEnumContainsCoffee() {
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
    }
}
