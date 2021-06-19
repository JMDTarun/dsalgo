package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {

	// Given a string with lowercase letters only, if you are allowed to replace no
	// more than ‘k’ letters with any letter, find the length of the longest
	// substring having the same letters after replacement.

	// Input: String="aabccbb", k=2
	// Output: 5
	// Explanation: Replace the two 'c' with 'b' to have a longest repeating
	// substring "bbbbb".
	//
	// Input: String="abbcb", k=1
	// Output: 4
	// Explanation: Replace the 'c' with 'b' to have a longest repeating substring
	// "bbbb".
	//
	// Input: String="abccde", k=1
	// Output: 3
	// Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating
	// substring "ccc".

	public static int findLength(String str, int size) {
		Map<Character, Integer> countMap = new HashMap<>();
		char[] arr = str.toCharArray();
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = Integer.MIN_VALUE;
		int maxCharactersSoFar = Integer.MIN_VALUE;
		while (windowEnd < arr.length) {
			countMap.compute(arr[windowEnd], (k, v) -> (v == null) ? 1 : v + 1);
			maxCharactersSoFar = Math.max(maxCharactersSoFar, countMap.get(arr[windowEnd]));
			if ((windowEnd - windowStart + 1) - maxCharactersSoFar > size) {
				countMap.compute(arr[windowStart], (k, v) -> v - 1);
				windowStart++;
			}
			maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
			windowEnd++;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(findLength("aabcaabbaaa", 1));
	}

}
