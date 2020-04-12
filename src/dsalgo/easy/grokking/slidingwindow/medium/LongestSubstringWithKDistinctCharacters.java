package dsalgo.easy.grokking.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

	// Given a string, find the length of the longest substring in it with no more
	// than K distinct characters.
	//
	// Input: String="araaci", K=2
	// Output: 4
	// Explanation: The longest substring with no more than '2' distinct characters
	// is "araa".
	//
	//
	// Input: String="araaci", K=1
	// Output: 2
	// Explanation: The longest substring with no more than '1' distinct characters
	// is "aa".
	//
	//
	// Input: String="cbbebi", K=3
	// Output: 5
	// Explanation: The longest substrings with no more than '3' distinct characters
	// are "cbbeb" & "bbebi".
	//

	public static int findLengh(String str, int k) {
		Map<Character, Integer> characterMap = new HashMap<>();
		char[] arr = str.toCharArray();
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = 0;

		while (windowEnd < arr.length) {
			if (characterMap.get(arr[windowEnd]) != null) {
				Integer occurances = characterMap.get(arr[windowEnd]);
				characterMap.put(arr[windowEnd], ++occurances);
			} else {
				characterMap.put(arr[windowEnd], 1);
			}
			windowEnd++;
			while (characterMap.size() > k) {
				Integer occurances = characterMap.get(arr[windowStart]);
				occurances -= 1;
				if (occurances == 0) {
					characterMap.remove(arr[windowStart]);
				} else {
					characterMap.put(arr[windowStart], occurances);
				}
				windowStart++;
			}

			if (characterMap.size() == k) {
				if (maxLength < (windowEnd - windowStart)) {
					maxLength = windowEnd - windowStart;
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int findLengh = findLengh("cbbebi", 3);
		System.out.println(findLengh);
	}

}
