package dsalgo.easy.grokking.twopointer.medium;

import java.util.Arrays;

public class TripletSumCloseToTarget {

	// Given an array of unsorted numbers and a target number, find a triplet in the
	// array whose sum is as close to the target number as possible, return the sum
	// of the triplet. If there are more than one such triplet, return the sum of
	// the triplet with the smallest sum.
	//
	// Example 1:
	//
	// Input: [-2, 0, 1, 2], target=2
	// Output: 1
	// Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
	// Example 2:
	//
	// Input: [-3, -1, 1, 2], target=1
	// Output: 0
	// Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
	// Example 3:
	//
	// Input: [1, 0, 1, 1], target=100
	// Output: 3
	// Explanation: The triplet [1, 1, 1] has the closest sum to the target.

	public static int searchTriplet(int[] nums, int target) {

		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int startPointer = i + 1;
			int endPointer = nums.length - 1;
			while (startPointer < endPointer) {
				int sum = nums[startPointer] + nums[endPointer] + nums[i];

				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}

				if (sum < target) {
					startPointer++;
				} else {
					endPointer--;
				}
			}
		}
		return diff == Integer.MAX_VALUE ? -1 : target - diff;
	}

	public static void main(String[] args) {

		System.out.println(searchTriplet(new int[] { -3, -2, -5, 3, -4 }, -1));
	}

}
