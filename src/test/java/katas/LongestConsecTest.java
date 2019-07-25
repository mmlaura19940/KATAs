package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.LongestConsecApp;

class LongestConsecTest {

	@Test
	void test() {
		final LongestConsecApp longestConsecObj = new LongestConsecApp();
		String[] s1 = { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"};
		String [] s2= {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
		assertEquals("abigailtheta", longestConsecObj.longestConsec(s1,2));
		assertEquals("oocccffuucccjjjkkkjyyyeehh", longestConsecObj.longestConsec(s2,1));
	}

}
