package dsalgo.easy.grokking.twopointer.medium;

import java.util.ArrayList;
import java.util.List;

public class SubarraysWithProductLessThanTarget {

	// Given an array with positive numbers and a target number, find all of its
	// contiguous subarrays whose product is less than the target number.
	//
	// Example 1:
	//
	// Input: [2, 5, 3, 10], target=30
	// Output: [2], [5], [2, 5], [3], [5, 3], [10]
	// Explanation: There are six contiguous subarrays whose product is less than
	// the target.
	// Example 2:
	//
	// Input: [8, 2, 6, 5], target=50
	// Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
	// Explanation: There are seven contiguous subarrays whose product is less than
	// the target.

	public static List<List<Integer>> fundSubArrays(int[] arr, int target) {
		List<List<Integer>> subArrays = new ArrayList<>();
		int endPointer = 0;
		int startPointer = 0;
		int product = arr[0];
		while (startPointer < arr.length && endPointer < arr.length) {
			if (product < target) {
				List<Integer> list = null;
				if (startPointer != endPointer) {
					list = new ArrayList<>();
					list.add(arr[endPointer]);
					subArrays.add(list);
				}
				list = new ArrayList<>();
				for (int i = startPointer; i <= endPointer; i++) {
					list.add(arr[i]);
				}
				subArrays.add(list);
				endPointer++;
				if (endPointer < arr.length) {
					product *= arr[endPointer];
				}
			} else {
				product /= arr[startPointer++];
			}
		}
		return subArrays;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 2, 6, 5 };
		System.out.println(fundSubArrays(arr, 50));
	}

}
