package katas;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoderApp {
	public String decode(String morseCode) {
		String result = "";
		Map<String, Character> morse = new HashMap<>();
		morse.put(".-", 'A');
		morse.put("-...", 'B');
		morse.put("-.-", 'C');
		morse.put("-..", 'D');
		morse.put(".", 'E');
		morse.put("..-.", 'F');
		morse.put("--.", 'G');
		morse.put("....", 'H');
		morse.put("..", 'I');
		morse.put(".---", 'J');
		morse.put("-.", 'K');
		morse.put(".-..", 'L');
		morse.put("--", 'M');
		morse.put("-.", 'N');
		morse.put("---", 'O');
		morse.put(".--.", 'P');
		morse.put("--.-", 'Q');
		morse.put(".-.", 'R');
		morse.put("...", 'S');
		morse.put("-", 'T');
		morse.put("..-", 'U');
		morse.put("...-", 'V');
		morse.put(".--", 'W');
		morse.put("-..-", 'X');
		morse.put("-.--", 'Y');
		morse.put("--..", 'Z');
		morse.put(".----", '1');
		morse.put("..---", '2');
		morse.put("...--", '3');
		morse.put("....-", '4');
		morse.put(".....", '5');
		morse.put("-....", '6');
		morse.put("--...", '7');
		morse.put("---..", '8');
		morse.put("----.", '9');
		morse.put("-----", '0');


		String[] words = morseCode.toString().split("\\s{2,}");
		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].trim().split(" ");
			for (int j = 0; j < letters.length; j++) {
				result = result.concat(String.format("%s ", morse.get(letters[j]).toString()));
			}
		}
		return result.trim();
	}
}
