package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

	public static boolean findPermutation(String str, String pattern) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			charMap.compute(pattern.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		int windowStart = 0;
		int windowEnd = 0;
		Map<Character, Integer> tempMap = new HashMap<>();
		while (windowEnd < str.length()) {
			if (charMap.containsKey(str.charAt(windowEnd))) {
				tempMap.compute(str.charAt(windowEnd), (k, v) -> v == null ? 1 : v + 1);
				if ((windowEnd - windowStart) + 1 == pattern.length() && tempMap.size() == charMap.size()) {
					return true;
				}
			} else {
				windowStart = windowEnd;
				tempMap.clear();
				windowStart++;
			}
			if ((windowEnd - windowStart) + 1 == pattern.length()) {
				tempMap.compute(str.charAt(windowStart), (k, v) -> v - 1);
				if (tempMap.get(str.charAt(windowStart)) == 0) {
					tempMap.remove(str.charAt(windowStart));
				}
				windowStart++;
			}
			windowEnd++;
		}
		return false;
	}

	public static boolean findPermutation1(String str, String pattern) {
		int start = 0;
		int end = 0;
		int counter = 0;
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			frequencyMap.compute(pattern.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		while (end < str.length()) {
			char endChar = str.charAt(end);

			if (frequencyMap.containsKey(endChar)) {
				frequencyMap.compute(endChar, (k, v) -> v - 1);
				if (frequencyMap.get(endChar) == 0) {
					counter++;
				}
			}
			if (counter == frequencyMap.size()) {
				return true;
			}
			if (end - start + 1 >= pattern.length()) {
				char startChar = str.charAt(start++);
				if (frequencyMap.containsKey(startChar)) {
					if (frequencyMap.get(startChar) == 0) {
						counter--;
					}
					frequencyMap.compute(startChar, (k, v) -> v + 1);
				}
			}
			end++;
		}
		return false;
	}

	public static void main(String[] args) {
//		"hello"
//		"ooolleoooleh"

//		"ab"
//		"eidboaoo"
//		
		System.out.println(findPermutation1("eidboaoo", "ab"));
		System.out.println(findPermutation("ppqp", "pq"));
	}

}
