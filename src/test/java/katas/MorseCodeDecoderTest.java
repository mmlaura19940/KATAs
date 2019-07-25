package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MorseCodeDecoderTest {

	@Test
	void test() {
		MorseCodeDecoderApp testObject= new MorseCodeDecoderApp();
		assertEquals("HEY JUDE", testObject.decode(".... . -.--     .--- ..- -.. ."));
	}

}
