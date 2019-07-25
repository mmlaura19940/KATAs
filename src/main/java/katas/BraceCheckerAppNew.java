package katas;
import java.util.Stack;

public class BraceCheckerAppNew {
	public boolean isValid(String braces) {
		boolean result = false;
		if (braces.length() % 2 != 0) {
			return result = false;
		}

		final char[] charOfBraces = braces.toCharArray();
		final Stack<Character> stackOfBraces = new Stack<>();

		for (int i = 0; i < charOfBraces.length; i++) {
			final char actualCharacter = charOfBraces[i];
			if (isOpening(actualCharacter)) {
				stackOfBraces.push(actualCharacter);
			}

			if (!isOpening(actualCharacter)) {
				if (stackOfBraces.isEmpty()) {
					return false;
				}

				if (!isValid(stackOfBraces.peek(), actualCharacter)) {
					return false;
				}

				stackOfBraces.pop();
			}
		}
		if (stackOfBraces.isEmpty()) {
			result = true;
		}
		return result;
	}

	private boolean isValid(Character lastOpeningBrace, char actualCharacter) {
		if ((actualCharacter == ')' && lastOpeningBrace == '(') || (actualCharacter == '}' && lastOpeningBrace == '{')
				|| (actualCharacter == ']' && lastOpeningBrace == '[')) {
			return true;
		}
		return false;
	}

	public boolean isOpening(char actual) {
		boolean result = false;
		if (actual == '(' || actual == '{' || actual == '[') {
			result = true;
		}

		return result;
	}

	public char getInverted(char actual) {
		char result = actual;
		if (actual == ')') {
			result = '(';
		} else if (actual == '}') {
			result = '{';
		} else {
			result = '[';
		}

		return result;
	}
}
