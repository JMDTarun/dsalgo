package dsalgo.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

	// Given an array of characters where each character represents a fruit tree,
	// you are given two baskets and your goal is to put maximum number of fruits in
	// each basket. The only restriction is that each basket can have only one type
	// of fruit.
	//
	// You can start with any tree, but once you have started you can’t skip a tree.
	// You will pick one fruit from each tree until you cannot, i.e., you will stop
	// when you have to pick from a third fruit type.
	//
	// Write a function to return the maximum number of fruits in both the baskets.

	// Input: Fruit=['A', 'B', 'C', 'A', 'C']
	// Output: 3
	// Explanation: We can put 2 'C' in one basket and one 'A' in the other from the
	// subarray ['C', 'A', 'C']
	//
	//
	// Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
	// Output: 5
	// Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
	// This can be done if we start with the second letter: ['B', 'C', 'B', 'B',
	// 'C']

	public static int findLengh(String str) {
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

			while (characterSet.size() > 2) {
				Integer occurances = characterSet.get(arr[windowStart]);
				occurances -= 1;
				if (occurances == 0) {
					characterSet.remove(arr[windowStart]);
				} else {
					characterSet.put(arr[windowStart], occurances);
				}
				windowStart++;
			}
			if (characterSet.size() <= 2) {
				if (maxLength < (windowEnd - windowStart)) {
					maxLength = windowEnd - windowStart;
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int findLengh = findLengh("abcac");
		System.out.println(findLengh);
	}

}
