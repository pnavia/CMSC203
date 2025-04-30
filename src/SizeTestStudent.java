import static org.junit.Assert.*;
import org.junit.Test;

public class SizeTestStudent {
    @Test
    public void testEnumContainsLarge() {
        assertEquals(Size.LARGE, Size.valueOf("LARGE"));
    }
}