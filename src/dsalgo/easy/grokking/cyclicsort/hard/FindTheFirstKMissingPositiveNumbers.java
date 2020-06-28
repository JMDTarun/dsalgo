package dsalgo.easy.grokking.cyclicsort.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheFirstKMissingPositiveNumbers {

	// Given an unsorted array containing numbers and a number ‘k’, find the first
	// ‘k’ missing positive numbers in the array.
	//
	// Example 1:
	//
	// Input: [3, -1, 4, 5, 5], k=3
	// Output: [1, 2, 6]
	// Explanation: The smallest missing positive numbers are 1, 2 and 6.
	// Example 2:
	//
	// Input: [2, 3, 4], k=3
	// Output: [1, 5, 6]
	// Explanation: The smallest missing positive numbers are 1, 5 and 6.
	// Example 3:
	//
	// Input: [-2, -3, 4], k=2
	// Output: [1, 2]
	// Explanation: The smallest missing positive numbers are 1 and 2.

	public static List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		int startIndex = 0;
		while (startIndex < nums.length) {
			if (nums[startIndex] <= 0 || nums[startIndex] == startIndex + 1 || nums[startIndex] > nums.length) {
				startIndex++;
			} else {
				int temp = nums[startIndex];
				if (temp == nums[temp - 1]) {
					startIndex++;
				} else {
					nums[startIndex] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length && result.size() < k; i++) {
			if (nums[i] != i + 1) {
				if (!set.contains(i + 1)) {
					result.add(i + 1);
				}
				set.add(nums[i]);
			}
		}

		int start = 1;
		while (result.size() < k) {
			if (!set.contains(nums.length + start)) {
				result.add(nums.length + start);
			}
			start++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3));
		System.out.println(findNumbers(new int[] { 2, 3, 4 }, 3));
		System.out.println(findNumbers(new int[] { -2, -3, 4 }, 2));
	}

}
