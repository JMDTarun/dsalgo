package dsalgo.easy.grokking.twopointer.medium;

import java.util.Arrays;

public class TripletsWithSmallerSum {

	// Given an array arr of unsorted numbers and a target sum, count all triplets
	// in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
	// different indices. Write a function to return the count of such triplets.
	//
	// Example 1:
	//
	// Input: [-1, 0, 2, 3], target=3
	// Output: 2
	// Explanation: There are two triplets whose sum is less than the target: [-1,
	// 0, 3], [-1, 0, 2]
	// Example 2:
	//
	// Input: [-1, 4, 2, 1, 3], target=5
	// Output: 4
	// Explanation: There are four triplets whose sum is less than the target:
	// [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

	public static int searchTriplets(int[] arr, int target) {
		int count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int startPointer = i + 1;
			int endPointer = arr.length - 1;
			while (startPointer < endPointer) {
				int sum = arr[i] + arr[startPointer] + arr[endPointer];
				if (sum < target) {
					count += endPointer - startPointer;
					startPointer++;
				} else {
					endPointer--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(searchTriplets(new int[] { 5, 1, 3, 4, 7 }, 12));
	}

}
