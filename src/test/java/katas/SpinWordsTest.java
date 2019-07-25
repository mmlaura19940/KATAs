package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.SpinWordsApp;

class SpinWordsTest {

	@Test
	void test() {
		final SpinWordsApp spinWords = new SpinWordsApp();
		assertEquals("emocleW", spinWords.spinWords("Welcome"));
		assertEquals("emocleW  this", spinWords.spinWords("Welcome  this"));
		assertEquals("Just gniddik [ereht is llits] one more", spinWords.spinWords("Just kidding [there is still] one more"));
		assertEquals("Hey wollef sroirraw", spinWords.spinWords("Hey fellow warriors"));
		assertEquals("emocleW", spinWords.spinWords2("Welcome"));
		assertEquals("emocleW  this", spinWords.spinWords2("Welcome  this"));
		assertEquals("Just gniddik [ereht is llits] one more", spinWords.spinWords2("Just kidding [there is still] one more"));
		assertEquals("Hey wollef sroirraw", spinWords.spinWords2("Hey fellow warriors"));
	}

}
