package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.BraceCheckerApp;
import katas.BraceCheckerAppNew;

class BraceCheckerTest {

	@Test
	void test() {
		final BraceCheckerApp isValidObj = new BraceCheckerApp();
		final BraceCheckerAppNew isValidTesterObj = new BraceCheckerAppNew();

		assertEquals(false, isValidTesterObj.isValid(")(()"));
		assertEquals(false, isValidTesterObj.isValid("(])"));
		assertEquals(false, isValidTesterObj.isValid("[(])"));
		assertEquals(true, isValidTesterObj.isValid("({})"));
		assertEquals(true, isValidTesterObj.isValid("{(){}}"));
		assertEquals(true, isValidTesterObj.isValid("{(){}}{(){}}{(){}}"));

	}

}
