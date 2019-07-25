package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.ReverseOrRotateApp;

class ReverseOrRotateTest {

	private static void testing(String actual, String expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		final ReverseOrRotateApp testObject = new ReverseOrRotateApp();
		System.out.println("Fixed Tests: revRot");
		testing(testObject.reverseOrRotate("1234", 0), "");
		testing(testObject.reverseOrRotate("", 0), "");
		testing(testObject.reverseOrRotate("1234", 5), "");
		String s = "733049910872815764";
		testing(testObject.reverseOrRotate(s, 5), "330479108928157");

	}

}
