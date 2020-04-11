package dsalgo.medium.slidingwindow;

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
		Map<Character, Integer> characterSet = new HashMap<>();
		char[] arr = str.toCharArray();
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = 0;

		while (windowEnd < arr.length) {
			if (characterSet.get(arr[windowEnd]) != null) {
				Integer occurances = characterSet.get(arr[windowEnd]);
				characterSet.put(arr[windowEnd], ++occurances);
				windowEnd++;
			} else {
				characterSet.put(arr[windowEnd], 1);
				windowEnd++;
			}

			while (characterSet.size() > k) {
				Integer occurances = characterSet.get(arr[windowStart]);
				occurances -= 1;
				if (occurances == 0) {
					characterSet.remove(arr[windowStart]);
				} else {
					characterSet.put(arr[windowStart], occurances);
				}
				windowStart++;
			}

			if (characterSet.size() <= k) {
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
