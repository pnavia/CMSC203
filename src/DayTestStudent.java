import static org.junit.Assert.*;
import org.junit.Test;

public class DayTestStudent {
    @Test
    public void testEnumContainsMonday() {
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
    }
}
