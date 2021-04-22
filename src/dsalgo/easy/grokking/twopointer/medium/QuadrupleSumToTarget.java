package dsalgo.easy.grokking.twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuadrupleSumToTarget {

	// Given an array of unsorted numbers and a target number, find all unique
	// quadruplets in it, whose sum is equal to the target number.
	//
	// Example 1:
	//
	// Input: [4, 1, 2, -1, 1, -3], target=1
	// Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
	// Explanation: Both the quadruplets add up to the target.
	// Example 2:
	//
	// Input: [2, 0, -1, 1, -2, 2], target=2
	// Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
	// Explanation: Both the quadruplets add up to the target.

	public static List<List<Integer>> searchQuadruple(int[] nums, int target) {
		Set<List<Integer>> triplets = new HashSet<>();
		Arrays.sort(nums);
		List<Integer> triplet = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int startPointer = j + 1;
				int endPointer = nums.length - 1;
				triplet.add(nums[i]);
				triplet.add(nums[j]);
				while (startPointer < endPointer) {
					if ((nums[startPointer] + nums[endPointer]) + nums[i] + nums[j] == target) {
						triplet.add(nums[startPointer]);
						triplet.add(nums[endPointer]);
						startPointer++;
						endPointer--;
						triplets.add(new ArrayList<>(triplet));
						triplet.clear();
						triplet.add(nums[i]);
						triplet.add(nums[j]);
					} else if ((nums[startPointer] + nums[endPointer]) + nums[i] <= target) {
						startPointer++;
					} else {
						endPointer--;
					}
				}
				triplet.clear();
			}
			triplet.clear();
		}
		return new ArrayList<List<Integer>>(triplets);
	}

	public static void main(String[] args) {
		
//		[-2,-1,-1,1,1,2,2]
		
		System.out.println(searchQuadruple(new int[] {-2,-1,-1,1,1,2,2 }, 0));
//		System.out.println(searchQuadruple(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}

}
