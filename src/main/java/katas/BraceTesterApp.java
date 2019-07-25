package katas;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BraceTesterApp {
	public boolean isValid(String braces) {
		boolean result = false;
		if (!(braces.length() % 2 == 0)) {
			return result = false;
		}
		char[] charOfBraces = braces.toCharArray();

		Queue<Character> queueBraces = new LinkedList<>();
		for (int i = 0; i < charOfBraces.length; i++) {
			queueBraces.add(charOfBraces[i]);
		}
		List<Character> enqueuedList = new ArrayList<>();

		result = removePairs(enqueuedList, queueBraces, charOfBraces);
		// characterStack
		// iter
			// if opening
				// characterStack push
			// if closing
				// characterStack peek
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

	public boolean checkMiddle(List<Character> list) {
		boolean result = false;
		if (list.size() == 0) {
			result = true;
		} else {
			int leftPosition = list.size() / 2 - 1;
			char left = list.get(leftPosition);
			int rightPosition = list.size() / 2;
			char right = list.get(rightPosition);
			if (left == getInverted(right)) {
				list.remove(leftPosition);
				list.remove(rightPosition - 1);
				result = checkMiddle(list);
			}
		}
		return result;
	}

	public boolean removePairs(List<Character> list, Queue<Character> queue, char[] chars) {
		boolean result = false;
		for (char c : chars) {
			char actual = queue.remove();
			list.add(actual);
			if (queue.size() == 0) {
				break;
			}
			if (list.get(list.size() - 1) == getInverted(queue.element())) {
				list.remove(list.size() - 1);
				queue.remove();
				if (queue.size() == 0) {
					break;
				}
			}
		}
		if (list.size() > 0) {
			if (list.size() % 2 != 0) {
				result = false;
			}
			result = checkMiddle(list);
			if (queue.isEmpty() && result == false && list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					queue.add(list.get(i));
				}
				list.removeAll(list);
				result = removePairs(list, queue, chars);
			}
		}

		else {
			result = true;
		}
		return result;

	}
}
