package dsalgo.easy.grokking.twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static List<List<Integer>> searchQuadruple(int[] arr, int target) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);

		List<Integer> triplet = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int startPointer = j + 1;
				int endPointer = arr.length - 1;
				triplet.add(arr[i]);
				triplet.add(arr[j]);
				while (startPointer < endPointer) {
					if ((arr[startPointer] + arr[endPointer]) + arr[i] + arr[j] == target) {
						triplet.add(arr[startPointer]);
						triplet.add(arr[endPointer]);
						startPointer++;
						endPointer--;
						triplets.add(new ArrayList<>(triplet));
						triplet.clear();
						triplet.add(arr[i]);
					} else if ((arr[startPointer] + arr[endPointer]) + arr[i] <= target) {
						startPointer++;
					} else {
						endPointer--;
					}
				}
				triplet.clear();
			}
			triplet.clear();
		}
		return triplets;
	}

	public static void main(String[] args) {
		System.out.println(searchQuadruple(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(searchQuadruple(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}

}
