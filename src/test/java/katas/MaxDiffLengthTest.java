package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.MaxDiffLengthApp;

class MaxDiffLengthTest {

	@Test
	void test() {
		final MaxDiffLengthApp maxDiffLengthObj = new MaxDiffLengthApp();
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        String[] s3 = new String[] {};
      
        assertEquals(-1, maxDiffLengthObj.maxDiffLength(s1, s3));
        assertEquals(13, maxDiffLengthObj.maxDiffLength(s1, s2));
        
	}

}
