package katas;

public class sequenceSumApp {
	public int sequenceSum(int begin, int end, int step) {
		if (begin > end) {
			return 0;
		}
		int sum = 0;
		while (begin <= end) {
			sum += begin;
			begin += step;
		}
		return sum;
	}

}
