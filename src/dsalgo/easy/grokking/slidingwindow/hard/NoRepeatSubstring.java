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
		int windowEnd = 0;
		int maxLength = 1;
		Set<Character> set = new HashSet<>();
		set.add(arr[windowEnd]);
		while (windowEnd < arr.length - 1) {
			windowEnd++;
			if (set.contains(arr[windowEnd])) {
				set.clear();
				set.add(arr[windowEnd]);
			} else {
				set.add(arr[windowEnd]);
			}
			maxLength = Math.max(maxLength, set.size());
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "abccdef";
		int findLength = findLength(s);
		System.out.println(findLength);
	}

}
