package dsalgo.easy.grokking.slidingwindow.easy;

public class MaximumSumSubarrayOfSizeK {

	// Given an array of positive numbers and a positive number ‘k’, find the
	// maximum sum of any contiguous subarray of size ‘k’.

	// Input: [2, 1, 5, 1, 3, 2], k=3
	// Output: 9
	// Explanation: Subarray with maximum sum is [5, 1, 3].

	// Input: [2, 3, 4, 1, 5], k=2
	// Output: 7
	// Explanation: Subarray with maximum sum is [3, 4].

	private int findMaxSubarray(int[] arr, int size) {
		int maxSoFar = Integer.MIN_VALUE;
		int j = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < size) {
				sum += arr[i];
			} else {
				if (sum > maxSoFar) {
					maxSoFar = sum;
				}
				sum -= arr[j];
				sum += arr[i];
				j++;
			}

		}
		if (sum > maxSoFar) {
			maxSoFar = sum;
		}
		return maxSoFar;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 1, 3, 8 };
		int size = 3;

		MaximumSumSubarrayOfSizeK maximumSumSubarrayOfSizeK = new MaximumSumSubarrayOfSizeK();
		int max = maximumSumSubarrayOfSizeK.findMaxSubarray(arr, size);
		System.out.println(max);

	}

}
