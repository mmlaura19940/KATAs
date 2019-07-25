package katas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import katas.HowGoodAreYouReallyApp;

public class HowGoodAreYouReallyTest {
	@Test
	  public void testPerformance() {  
		
		final HowGoodAreYouReallyApp testObject = new HowGoodAreYouReallyApp();  
	    assertEquals(true, testObject.betterThanAverage(new int[] {1, 1}, 5));
	    
	  }

}
