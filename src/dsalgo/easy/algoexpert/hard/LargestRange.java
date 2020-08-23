package dsalgo.easy.algoexpert.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

	// Given an unsorted array of integers, find the length of the longest
	// consecutive elements sequence.
	//
	// Your algorithm should run in O(n) complexity.
	//
	// Example:
	//
	// Input: [100, 4, 200, 1, 3, 2]
	// Output: 4
	// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
	// Therefore its length is 4.

	public static int longestConsecutive(int[] nums) {
		int max = Integer.MIN_VALUE;
		Map<Integer, Boolean> numMap = new HashMap<Integer, Boolean>();
		for (Integer i : nums) {
			numMap.put(i, true);
		}

		int count = 0;
		for (Integer i : nums) {
			int next = i;
			int prev = i;

			while (numMap.containsKey(++next) && numMap.get(next) != false) {
				numMap.put(++next, false);
				count++;
			}

			while (numMap.containsKey(--prev) && numMap.get(prev) != false) {
				numMap.put(prev, false);
				count++;
			}
			max = Math.max(count, max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

}
