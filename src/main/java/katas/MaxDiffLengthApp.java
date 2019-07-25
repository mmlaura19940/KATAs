package katas;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxDiffLengthApp {
	public int maxDiffLength(String[] a1, String[] a2) {

		List<String> stringArray1 = Arrays.asList(a1);
		List<String> stringArray2 = Arrays.asList(a2);

		if (stringArray1.isEmpty() || stringArray2.isEmpty()) {
			return -1;
		}

		int shortestA1Length = stringArray1.stream().min(Comparator.comparing(String::length)).get().length();
		int largestA1Length = stringArray1.stream().max(Comparator.comparing(String::length)).get().length();

		int shortestA2Length = stringArray2.stream().min(Comparator.comparing(String::length)).get().length();
		int largestA2Length = stringArray2.stream().max(Comparator.comparing(String::length)).get().length();

		if (largestA1Length - shortestA2Length > largestA2Length - shortestA1Length) {
			return largestA1Length - shortestA2Length;
		}
		return largestA2Length - shortestA1Length;
			
//		if (largestA1Length == largestA2Length) {
//			if (largestA1Length - shortestA2Length > largestA2Length - shortestA1Length) {
//				return largestA1Length - shortestA2Length;
//			}
//			return largestA2Length - shortestA1Length;
//
//			// Substract largest a1 from smallest a2 and largest a2 from smallest a1 compare
//			// and return the lowest value
//		} else if (largestA1Length > largestA2Length && shortestA1Length > shortestA2Length) {
//
//			return largestA1Length - shortestA2Length;
//
//		} else {
//			return largestA2Length - shortestA1Length;
//		}
	}

}
