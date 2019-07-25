package katas;
public class ReverseWordsApp {

	public String reverseWords(String str) {

		final String[] partsOfStr = str.trim().split(" "); // trim: delete leading and trailing whitespace
		final StringBuilder stringBuilder = new StringBuilder();
		for (int i = partsOfStr.length -1; i >= 0; i--) {
			stringBuilder.append(partsOfStr[i]);
			stringBuilder.append(" ");
		}

		return stringBuilder.toString().trim();
	}

}
