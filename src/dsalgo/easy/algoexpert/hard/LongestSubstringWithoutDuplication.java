package dsalgo.easy.algoexpert.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

	// Given a string, find the length of the longest substring without repeating
	// characters.
	//
	// Example 1:
	//
	// Input: "abcabcbb"
	// Output: 3
	// Explanation: The answer is "abc", with the length of 3.
	// Example 2:
	//
	// Input: "bbbbb"
	// Output: 1
	// Explanation: The answer is "b", with the length of 1.
	// Example 3:
	//
	// Input: "pwwkew"
	// Output: 3
	// Explanation: The answer is "wke", with the length of 3.
	// Note that the answer must be a substring, "pwke" is a subsequence and not a
	// substring.

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		char[] arr = s.toCharArray();
		while (end < arr.length) {
			map.compute(arr[end], (k, v) -> v != null ? v + 1 : 1);
			if (map.get(arr[end]) > 1) {
				while (map.get(arr[end]) > 1) {
					map.compute(arr[start], (k, v) -> v - 1);
					if (map.get(arr[start]) == 0) {
						map.remove(arr[start]);
					}
					start++;
				}
			}
			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("GEEKSFORGEEKS"));
	}

}
