package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.sequenceSumApp;

class sequenceSumTest {

	@Test
	void test() {
		final sequenceSumApp sequenceSumObj = new sequenceSumApp();
		assertEquals(12, sequenceSumObj.sequenceSum(2, 6, 2));
		assertEquals(15, sequenceSumObj.sequenceSum(1, 5, 1));
		assertEquals(5, sequenceSumObj.sequenceSum(1, 5, 3));
	}

}
