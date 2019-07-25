package katas;
public class LongestConsecApp {

	public String longestConsec(String[] strArr, int k) {
		if (strArr.length == 0 || strArr.length < k || k <= 0) {
			return "";
		}
		
		int maxLength = 0;
		String longestString = "";

		for (int i = 0; i <= strArr.length - k; i++) {
			String selectedString = "";
			for (int j = i; j < i + k; j++) {
				selectedString = selectedString.concat(strArr[j]);
			}
			
			if (selectedString.length() > maxLength) {
				maxLength = selectedString.length();
				longestString = selectedString;
			}
		}
		return longestString;
	}
}
