package application;

/*
 * Class: CMSC203 
 * Instructor: Tarek, Ahmed
 * Description: JUnit test class for Plot.java
 * Due: 04/04/2025
 * Platform/compiler: Eclipse  
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot p = new Plot(2, 4, 6, 8);
        assertEquals(2, p.getX());
        assertEquals(4, p.getY());
        assertEquals(6, p.getWidth());
        assertEquals(8, p.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot p1 = new Plot(1, 1, 2, 2);
        Plot p2 = new Plot(p1);
        assertEquals(1, p2.getX());
        assertEquals(2, p2.getWidth());
    }

    @Test
    public void testOverlaps() {
        Plot p1 = new Plot(1, 1, 4, 4);
        Plot p2 = new Plot(2, 2, 3, 3);
        assertTrue(p1.overlaps(p2));

        Plot p3 = new Plot(10, 10, 2, 2);
        assertFalse(p1.overlaps(p3));
    }

    @Test
    public void testEncompasses() {
        Plot p1 = new Plot(1, 1, 5, 5);
        Plot p2 = new Plot(2, 2, 2, 2);
        assertTrue(p1.encompasses(p2));

        Plot p3 = new Plot(0, 0, 6, 6);
        assertFalse(p1.encompasses(p3));
    }

    @Test
    public void testToString() {
        Plot p = new Plot(3, 4, 5, 6);
        assertEquals("3,4,5,6", p.toString());
    }
}
