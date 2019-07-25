package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.ReverseWordsApp;


// TODO: Replace examples and use TDD development by writing your own tests

public class ReverseWordsTest {
    @Test
    public void testWords() {
    	final ReverseWordsApp testObject = new ReverseWordsApp();
         assertEquals("eating like I", testObject.reverseWords("I like eating"));
         assertEquals("flying like I", testObject.reverseWords("I like flying"));
         assertEquals("nice is world The", testObject.reverseWords("The world is nice"));
         assertEquals("nice is world, The", testObject.reverseWords("The world, is nice"));
         assertEquals("nice is    world The", testObject.reverseWords("The world    is nice"));
    }
}