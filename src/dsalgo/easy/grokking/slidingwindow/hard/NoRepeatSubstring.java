package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {

	// Given a string, find the length of the longest substring which has no
	// repeating characters.

	// Input: String="aabccbb"
	// Output: 3
	// Explanation: The longest substring without any repeating characters is "abc".

	// Input: String="abbbb"
	// Output: 2
	// Explanation: The longest substring without any repeating characters is "ab".

	// Input: String="abccde"
	// Output: 3
	// Explanation: Longest substrings without any repeating characters are "abc" &
	// "cde".

	public static int findLength(String str) {
		char[] arr = str.toCharArray();
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = 1;
		Set<Character> set = new HashSet<>();

		while (windowEnd < arr.length) {
			if (set.contains(arr[windowEnd])) {
				set.remove(arr[windowStart]);
				windowStart++;
			} else {
				set.add(arr[windowEnd]);
				windowEnd++;
				maxLength = Math.max(maxLength, set.size());
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "abccdea";
		int findLength = findLength(s);
		System.out.println(findLength);
	}

}
