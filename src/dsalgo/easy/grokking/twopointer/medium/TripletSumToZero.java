package dsalgo.easy.grokking.twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSumToZero {

	// Given an array of unsorted numbers, find all unique triplets in it that add
	// up to zero.

	// Input: [-3, 0, 1, 2, -1, 1, -2]
	// Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
	// Explanation: There are four unique triplets whose sum is equal to zero.
	//
	// Input: [-5, 2, -1, -2, 3]
	// Output: [[-5, 2, 3], [-2, -1, 3]]
	// Explanation: There are two unique triplets whose sum is equal to zero.

	public static List<List<Integer>> searchTriplets(int[] nums) {
		Set<List<Integer>> triplets = new HashSet<>();
		Arrays.sort(nums);
		List<Integer> triplet = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int startPointer = i + 1;
			int endPointer = nums.length - 1;
			triplet.add(nums[i]);
			while (startPointer < endPointer) {
				if ((nums[startPointer] + nums[endPointer]) + nums[i] == 0) {
					triplet.add(nums[startPointer]);
					triplet.add(nums[endPointer]);
					startPointer++;
					endPointer--;
					triplets.add(new ArrayList<>(triplet));
					triplet.clear();
					triplet.add(nums[i]);

				} else if ((nums[startPointer] + nums[endPointer]) + nums[i] <= 0) {
					startPointer++;
				} else {
					endPointer--;
				}
			}
			triplet.clear();
		}
		return new ArrayList<List<Integer>>(triplets);
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println(searchTriplets(arr));
	}

}
