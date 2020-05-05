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

	public static void main(String[] args) {
		System.out.println(findPermutation("abcdedca", "cda"));
	}

}
