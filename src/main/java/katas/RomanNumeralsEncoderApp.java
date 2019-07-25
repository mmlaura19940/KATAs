package katas;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Laura
 *
 */
public class RomanNumeralsEncoderApp {

	public String createRomanNumeral(int n) {
		String result = "";
		final Map<Integer, String> mapOfNumbers = new TreeMap<Integer, String>();
		mapOfNumbers.put(1000, "M");
		mapOfNumbers.put(900, "CM");
		mapOfNumbers.put(500, "D");
		mapOfNumbers.put(400, "CD");
		mapOfNumbers.put(100, "C");
		mapOfNumbers.put(90, "XC");
		mapOfNumbers.put(50, "L");
		mapOfNumbers.put(40, "XL");
		mapOfNumbers.put(10, "X");
		mapOfNumbers.put(9, "IX");
		mapOfNumbers.put(5, "V");
		mapOfNumbers.put(4, "IV");
		mapOfNumbers.put(1, "I");
		
		while (n != 0) {
			int highest = 0;
			int count = 0;
			for (Integer highestNumber : mapOfNumbers.keySet()) {
				if (n >= highestNumber) {
					count = n / highestNumber;
					highest = highestNumber;
				} else {
					break;
				}
			}
			
			for (int i = 0; i < count; i++) {
				result = result.concat(mapOfNumbers.get(highest).toString());
			}
			n = n - highest * count;
		}

		return result;
	}

}
