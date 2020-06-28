package dsalgo.easy.grokking.dp.knapsack.medium;

import dsalgo.common.AlgoUtil;

public class MinimumSubsetSumDifference {

	// Given a set of positive numbers, partition the set into two subsets with
	// minimum difference between their subset sums.
	//
	// Example 1: #
	// Input: {1, 2, 3, 9}
	// Output: 3
	// Explanation: We can partition the given set into two subsets where minimum
	// absolute difference
	// between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} &
	// {9}.
	// Example 2: #
	// Input: {1, 2, 7, 1, 5}
	// Output: 0
	// Explanation: We can partition the given set into two subsets where minimum
	// absolute difference
	// between the sum of number is '0'. Following are the two subsets: {1, 2, 5} &
	// {7, 1}.
	// Example 3: #
	// Input: {1, 3, 100, 4}
	// Output: 92
	// Explanation: We can partition the given set into two subsets where minimum
	// absolute difference
	// between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} &
	// {100}.

	public static int minDifferencePartitionSubset(int arr[]) {
		int sum = 0;
		for (Integer i : arr) {
			sum += i;
		}
		int sumHalf = sum / 2;
		int[][] matrix = new int[arr.length + 1][sumHalf + 1];
		int max = 0;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (arr[i - 1] > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], arr[i - 1] + matrix[i - 1][j - arr[i - 1]]);
					if (matrix[i][j] <= sumHalf && max <= matrix[i][j]) {
						max = matrix[i][j];
					}
				}
			}
		}
		return sum - (max * 2);
	}

	public static void main(String[] args) {
		System.out.println(minDifferencePartitionSubset(new int[] { 1, 2, 3, 9 }));
		System.out.println(minDifferencePartitionSubset(new int[] { 1, 2, 7, 1, 5 }));
		System.out.println(minDifferencePartitionSubset(new int[] { 1, 3, 100, 4 }));
	}

}
