package katas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpinWordsApp {

	public String spinWords2(String sentence) {

		List<String> words = splitSentence(sentence);
		List<String> spinnedWords = new ArrayList<String>();
		for (String word : words) {

			String spinnedWord = spinWord(word);
			spinnedWords.add(spinnedWord);
		}
		return String.join(" ", spinnedWords);
	}

	private String spinWord(String word) {
		if (word.length() < 5) {
			return word;
		}

		final char[] charsOfWord = word.toCharArray();
		final List<Integer> indexes = new ArrayList<>();
		final List<Character> stringOfRest = new ArrayList<Character>();
		for (int j = 0; j < charsOfWord.length; j++) {
			if (!Character.isLetterOrDigit(charsOfWord[j])) {
				indexes.add(j);
			} else {
				stringOfRest.add(charsOfWord[j]);
			}
		}
		Collections.reverse(stringOfRest);
		for (int i = 0; i < indexes.size(); i++) {

			stringOfRest.add(indexes.get(i) - i, charsOfWord[indexes.get(i)]);
		}
		return stringOfRest.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());
		
	}

	private List<String> splitSentence(String sentence) {
		return Arrays.asList(sentence.trim().split(" "));
	}

	public String spinWords(String sentence) {
		final String[] partsOfSentence = sentence.trim().split(" ");
		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < partsOfSentence.length; i++) {
			String word = partsOfSentence[i];
			if (word.length() < 5) {
				stringBuilder.append(word);
			} else {
				final char[] charsOfWord = word.toCharArray();
				final List<Integer> indexes = new ArrayList<>();
				final StringBuilder stringOfRest = new StringBuilder();
				for (int j = 0; j < charsOfWord.length; j++) {
					if (!Character.isLetterOrDigit(charsOfWord[j])) {
						indexes.add(j);
					} else {
						stringOfRest.append(charsOfWord[j]);
					}
				}

				final char[] rest = stringOfRest.toString().trim().toCharArray();
				int restIndex = 0;
				for (int k = 0; k < charsOfWord.length; k++) {
					if (!indexes.isEmpty()) {
						for (int m = 0; m < indexes.size(); m++) {
							if (k == indexes.get(m)) {
								stringBuilder.append(charsOfWord[k]);
							} else {
								stringBuilder.append(rest[rest.length - restIndex - 1]);
								restIndex++;
							}

						}

					} else {
						stringBuilder.append(rest[rest.length - k - 1]);
					}
				}

			}

			stringBuilder.append(" ");
		}

		return stringBuilder.toString().trim();
	}

}
