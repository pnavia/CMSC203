package application;

/*
 * Class: CMSC203 
 * Instructor: Tarek, Ahmed
 * Description: JUnit test class for ManagementCompany.java
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

public class ManagementCompanyTestStudent {

    @Test
    public void testAddPropertyAndGetCount() {
        ManagementCompany mc = new ManagementCompany("PropCorp", "123456", 10);
        Property p = new Property("Tower", "City", 1200.0, "Landlord", 1, 1, 2, 2);
        int result = mc.addProperty(p);
        assertEquals(0, result);
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testGetTotalRent() {
        ManagementCompany mc = new ManagementCompany("ManageMe", "999999", 5);
        mc.addProperty("Villa", "Greenwood", 3000.0, "Oscar", 1, 1, 2, 2);
        mc.addProperty("Cabin", "Hilltop", 2000.0, "Emma", 4, 4, 2, 2);
        assertEquals(5000.0, mc.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        ManagementCompany mc = new ManagementCompany("MgtInc", "222222", 7.5);
        mc.addProperty("House A", "Town", 1500.0, "Bob", 0, 0, 2, 2);
        mc.addProperty("House B", "Town", 2200.0, "Alice", 3, 3, 2, 2);
        assertEquals("House B", mc.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testToString() {
        ManagementCompany mc = new ManagementCompany("RentAll", "111111", 10);
        mc.addProperty("The Ridge", "Valley", 2100.0, "Carl", 1, 1, 2, 2);
        String result = mc.toString();
        assertTrue(result.contains("The Ridge"));
        assertTrue(result.contains("total management Fee"));
    }

    @Test
    public void testAddPropertyFailsWhenOverlapping() {
        ManagementCompany mc = new ManagementCompany("Conflicts", "000000", 8);
        mc.addProperty("A", "City", 1000.0, "OwnerA", 1, 1, 3, 3);
        int result = mc.addProperty("B", "City", 1100.0, "OwnerB", 2, 2, 3, 3);
        assertEquals(-4, result);
    }

    @Test
    public void testIsPropertiesFull() {
        ManagementCompany mc = new ManagementCompany("FullHouse", "999999", 9);
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mc.addProperty("Prop" + i, "Zone", 1000 + i, "Manager", i, i, 1, 1);
        }
        assertTrue(mc.isPropertiesFull());
    }
}
