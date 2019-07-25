package katas;

public class ReverseOrRotateApp {
	public String reverseOrRotate(String str, int chunkSize) {
		if (chunkSize == 0 || str.length() == 0 || chunkSize > str.length()) {
			return "";
		}
		int start = 0;
		final char[] charsOfPart = str.toCharArray();
		boolean isContainNumber = false;
		for (int i = 0; i < charsOfPart.length; i++) {
			if (Character.isDigit(charsOfPart[i])) {
				isContainNumber = true;
			}
		}

		if (isContainNumber) {
			final StringBuilder stringBuilder = new StringBuilder();
			while (start <= str.length() - chunkSize) {
				int cube = 0;
				int sum = 0;
				for (int i = start; i < start + chunkSize; i++) {
					final int numericValue = Character.getNumericValue(charsOfPart[i]);
					cube = (int) Math.pow((double) numericValue, 3);
					sum += cube;
				}

				if (sum % 2 == 0) {
					for (int j = start + chunkSize - 1; j >= start; j--) {
						stringBuilder.append(charsOfPart[j]);
					}
				} else {
					for (int j = start; j < start + chunkSize; j++) {
						if (j != start) {
							stringBuilder.append(charsOfPart[j]);
						}
					}
					stringBuilder.append(charsOfPart[start]);
				}
				start = start + chunkSize;
			}
			return stringBuilder.toString().trim();
		}

		else {
			return str;
		}
	}

}
