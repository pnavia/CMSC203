package application;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a ManagementCompany object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 */
public class ManagementCompanyGFATest {
    Property sampleProperty;
    ManagementCompany mangementCo;

    @Before
    public void setUp() throws Exception {
        mangementCo = new ManagementCompany("Railey", "555555555", 6);
    }

    @After
    public void tearDown() throws Exception {
        mangementCo = null;
    }

    @Test
    public void testAddProperty() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);
        assertEquals(0, mangementCo.addProperty(sampleProperty));
    }

    @Test
    public void testGetPropertiesCount() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);
        mangementCo.addProperty(sampleProperty);
        assertEquals(1, mangementCo.getPropertiesCount());
    }

    @Test
    public void testToString() {
        sampleProperty = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
        mangementCo.addProperty(sampleProperty);
        String expectedString = "List of the properties for Railey, taxID: 555555555\n"
                + "______________________________________________________\n"
                + "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
                + "______________________________________________________\n\n"
                + " total management Fee: 156.78";
        assertEquals(expectedString, mangementCo.toString());
    }
}
