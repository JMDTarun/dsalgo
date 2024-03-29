package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

	// Given a string and a pattern, find the smallest substring in the given string
	// which has all the characters of the given pattern.
	//
	// Example 1:
	//
	// Input: String="aabdec", Pattern="abc"
	// Output: "abdec"
	// Explanation: The smallest substring having all characters of the pattern is
	// "abdec"
	// Example 2:
	//
	// Input: String="abdabca", Pattern="abc"
	// Output: "abc"
	// Explanation: The smallest substring having all characters of the pattern is
	// "abc".
	// Example 3:
	//
	// Input: String="adcad", Pattern="abc"
	// Output: ""
	// Explanation: No substring in the given string has all characters of the
	// pattern.

	public static String findSubsequence(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : t.toCharArray()) {
			map.compute(c, (k, v) -> v != null ? v + 1 : 1);
		}

		int windowStart = 0;
		int windowEnd = 0;
		int minWindowSize = Integer.MAX_VALUE;
		Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
		String minSubString = "";
		while (windowEnd < s.length()) {
			if (map.containsKey(s.charAt(windowEnd))) {
				tempMap.compute(s.charAt(windowEnd), (k, v) -> v != null ? v + 1 : 1);
				if (tempMap.size() == map.size()) {
					while (true) {
						if ((windowEnd - windowStart) + 1 < minWindowSize) {
							minWindowSize = (windowEnd - windowStart) + 1;
							minSubString = s.substring(windowStart, windowEnd + 1);
						}
						if (tempMap.get(s.charAt(windowStart)) == null) {
							windowStart++;
							continue;
						}
						tempMap.compute(s.charAt(windowStart), (k, v) -> v - 1);
						if (tempMap.get(s.charAt(windowStart)) != 0) {
							windowStart++;
						} else {
							windowStart = windowEnd;
							windowEnd--;
							tempMap.clear();
							break;
						}
					}
				}
			}
			windowEnd++;
		}
		return minSubString;
	}

	public static void main(String[] args) {
		System.out.println(findSubsequence("ADOBECODEBANC", "ABC").length());
//		System.out.println(findSubsequence("abdabca", "abc"));
//		System.out.println(findSubsequence("adcad", "abc"));

	}

}
