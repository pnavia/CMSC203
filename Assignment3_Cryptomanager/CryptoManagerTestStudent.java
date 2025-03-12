import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 31274
 * Instructor: tarek. ahmed
 * Description: Test file for the CryptoManager implementation
 * Due: 03/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source.  
 * I have not given my code to any student. 
 * Print your Name here: Paulo Navia
 */
public class CryptoManagerTestStudent {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("ASSIGNMENT"));
		assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
		assertTrue(CryptoManager.isStringInBounds("CMSC 203"));
		assertFalse(CryptoManager.isStringInBounds("assignment")); // lowercase is out of bounds
		assertFalse(CryptoManager.isStringInBounds("Hello!")); // ! is out of bounds
		assertFalse(CryptoManager.isStringInBounds("{PROGRAMMING}")); // { and } are out of bounds
	}

	@Test
	public void testCaesarEncryption() {
		assertEquals("M_UESYXQZF", CryptoManager.caesarEncryption("ASSIGNMENT", 12));
		assertEquals("UFAILDNBG", CryptoManager.caesarEncryption("ALGORITHM", 20));
		assertEquals("WIGYVMXC", CryptoManager.caesarEncryption("SECURITY", 4));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("Testing", 6)); // lowercase
		assertEquals("IFMMP!XPSME", CryptoManager.caesarEncryption("HELLO WORLD", 1));
		assertEquals("NXJ!G\\KIQO", CryptoManager.caesarEncryption("CMSC 203", 11));
	}

	@Test
	public void testCaesarDecryption() {
		assertEquals("ASSIGNMENT", CryptoManager.caesarDecryption("M_UESYXQZF", 12));
		assertEquals("ALGORITHM", CryptoManager.caesarDecryption("UFAILDNBG", 20));
		assertEquals("SECURITY", CryptoManager.caesarDecryption("WIGYVMXC", 4));
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("IFMMP!XPSME", 1));
		assertEquals("CMSC 203", CryptoManager.caesarDecryption("NXJ!G\\KIQO", 11));
		assertEquals("PYTHON", CryptoManager.caesarDecryption("!:?398", 169)); // Testing with large key
	}

	@Test
	public void testBellasoEncryption() {
		assertEquals("A\\]QWZ\\]T\\^F", CryptoManager.bellasoEncryption("ASSIGNMENT", "KEY"));
		assertEquals("AV[WZLR\\]_", CryptoManager.bellasoEncryption("ALGORITHM", "JAVA"));
		assertEquals("WMK[VMXG", CryptoManager.bellasoEncryption("SECURITY", "PASS"));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("Testing", "KEY")); // lowercase
		assertEquals("RJ&CV\"YTJ#RP", CryptoManager.bellasoEncryption("HELLO WORLD", "CRYPTO"));
	}

	@Test
	public void testBellasoDecryption() {
		assertEquals("ASSIGNMENT", CryptoManager.bellasoDecryption("A\\]QWZ\\]T\\^F", "KEY"));
		assertEquals("ALGORITHM", CryptoManager.bellasoDecryption("AV[WZLR\\]_", "JAVA"));
		assertEquals("SECURITY", CryptoManager.bellasoDecryption("WMK[VMXG", "PASS"));
		assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("RJ&CV\"YTJ#RP", "CRYPTO"));
		assertEquals("PROGRAMMING", CryptoManager.bellasoDecryption("XZ]KRT^[ZYX", "CODE"));
	}
}