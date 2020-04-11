package dsalgo.easy.grokking.twopointer.easy;

import java.util.Arrays;

public class PairWithTargetSum {

	// Given an array of sorted numbers and a target sum, find a pair in the array
	// whose sum is equal to the given target.
	//
	// Write a function to return the indices of the two numbers (i.e. the pair)
	// such that they add up to the given target.
	//
	// Input: [1, 2, 3, 4, 6], target=6
	// Output: [1, 3]
	// Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
	//
	// Input: [2, 5, 9, 11], target=11
	// Output: [0, 2]
	// Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

	private int[] pairWithTargetSum(int[] arr, int sum) {
		int i = 0;
		int j = arr.length - 1;
		int[] indexes = { -1, -1 };
		while (i < j) {
			if (arr[i] + arr[j] == sum) {
				indexes[0] = i;
				indexes[1] = j;
				return indexes;
			} else if (arr[i] + arr[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return indexes;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 9, 11 };
		int sum = 11;

		PairWithTargetSum pairWithTargetSum = new PairWithTargetSum();
		int[] indexes = pairWithTargetSum.pairWithTargetSum(arr, sum);
		for(int i : indexes) {
			System.out.println(i);
		}
	}
}
