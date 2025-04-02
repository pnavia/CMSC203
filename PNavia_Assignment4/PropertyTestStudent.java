package application;

/*
 * Class: CMSC203 
 * Instructor: Tarek, Ahmed
 * Description: JUnit test class for Property.java
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

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals("", p.getOwner());
        assertEquals(0.0, p.getRentAmount(), 0.001);
    }

    @Test
    public void testParameterizedConstructorWithoutPlot() {
        Property p = new Property("Skyline", "Rockville", 4500.0, "John");
        assertEquals("Skyline", p.getPropertyName());
        assertEquals("Rockville", p.getCity());
        assertEquals("John", p.getOwner());
        assertEquals(4500.0, p.getRentAmount(), 0.001);
    }

    @Test
    public void testParameterizedConstructorWithPlot() {
        Property p = new Property("Lakeside", "Silver Spring", 3000.0, "Jane", 2, 3, 4, 5);
        assertEquals("Lakeside", p.getPropertyName());
        assertEquals(2, p.getPlot().getX());
        assertEquals(5, p.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Property p1 = new Property("Hilltop", "Bethesda", 5000.0, "Alice", 1, 1, 3, 3);
        Property p2 = new Property(p1);
        assertEquals("Hilltop", p2.getPropertyName());
        assertEquals("Bethesda", p2.getCity());
        assertEquals(5000.0, p2.getRentAmount(), 0.001);
    }

    @Test
    public void testToString() {
        Property p = new Property("GardenView", "Germantown", 2500.0, "Mary");
        assertEquals("GardenView,Germantown,Mary,2500.0", p.toString());
    }
}
