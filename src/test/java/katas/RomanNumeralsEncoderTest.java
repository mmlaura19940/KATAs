package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.RomanNumeralsEncoderApp;

class RomanNumeralsEncoderTest {

	@Test
	void test() {
		final RomanNumeralsEncoderApp testObject = new RomanNumeralsEncoderApp();
		assertEquals("V", testObject.createRomanNumeral(5));
		assertEquals("VI", testObject.createRomanNumeral(6));
		assertEquals("MVI", testObject.createRomanNumeral(1006));
		assertEquals("XLIV", testObject.createRomanNumeral(44));
		
//		assertEquals("XXXII", testObject.createRomanNumeral(32));
		}

}
