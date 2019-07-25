package katas;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BraceCheckerApp {

	public boolean isValid(String braces) {
		if (!(braces.length() % 2 == 0)) {
			return false;
		}
		char[] charOfBraces = braces.toCharArray();
		char[] braceTypes = { '(', ')', '[', ']', '{', '}' };
		Stack<Character> stackOfBraces = new Stack<>();
		for (int i = 0; i < charOfBraces.length; i++) {
			stackOfBraces.push(charOfBraces[i]);
		}
		List<List<Integer>> listOfpositions = new ArrayList<List<Integer>>();
		for (int i = 0; i < braceTypes.length; i++) {
			listOfpositions.add(positionOfBraceType(braceTypes[i], stackOfBraces));
		}
		boolean correctRoundBraces = isCorrect(listOfpositions.get(0), listOfpositions.get(1), braces);
		boolean correctSquareBraces = isCorrect(listOfpositions.get(2), listOfpositions.get(3), braces);
		boolean correctCurlyBraces = isCorrect(listOfpositions.get(4), listOfpositions.get(5), braces);
		if (correctRoundBraces && correctCurlyBraces && correctSquareBraces) {
			return true;
		}
		return false;
	}

	public List<Integer> positionOfBraceType(char braceType, Stack<Character> stackOfBraces) {
		List<Integer> positionOfBraceType = new ArrayList<Integer>();
		positionOfBraceType.add(stackOfBraces.search(braceType) - 1);
		return positionOfBraceType;
	}

	public boolean isCorrect(List<Integer> listOfpositions1, List<Integer> listOfpositions2, String braces) {
		boolean allCorrect = false;
		if (listOfpositions1.get(0) == -2) {
			return true;
		}
		if (listOfpositions1.size() == listOfpositions2.size()) {
			for (int j = 0; j < listOfpositions1.size(); j++) {
				if (listOfpositions2.get(j) + 1 == listOfpositions1.get(j)) {
					allCorrect = true;
				} else if (listOfpositions2.get(j) == braces.length() - 1
						- listOfpositions1.get(listOfpositions1.size() - j - 1)) {
					allCorrect = true;
				} else {
					allCorrect = false;
				}
			}
		}
		return allCorrect;
	}

}
