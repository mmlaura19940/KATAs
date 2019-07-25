package katas;

public class HowGoodAreYouReallyApp {

	public boolean betterThanAverage(int[] classPoints, int yourPoints) {
		int average = 0;

		for (int i = 0; i < classPoints.length; i++) {
			average = average + classPoints[i];
		}
		
		average /= classPoints.length;
		
		if (average < yourPoints) {
			return true;
		}

		return false;
	}

}
