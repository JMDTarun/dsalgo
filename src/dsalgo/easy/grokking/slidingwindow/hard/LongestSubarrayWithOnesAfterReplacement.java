package dsalgo.easy.grokking.slidingwindow.hard;

public class LongestSubarrayWithOnesAfterReplacement {

	// Given an array containing 0s and 1s, if you are allowed to replace no more
	// than ‘k’ 0s with 1s, find the length of the longest contiguous subarray
	// having all 1s.

	// Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
	// Output: 6
	// Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous
	// subarray of 1s having length 6.

	// Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
	// Output: 9
	// Explanation: Replace the '0' at index 6, 9, and 10 to have the longest
	// contiguous subarray of 1s having length 9.

	public static int findLength(int[] arr, int k) {
		int zeroCount = 0;
		int windowStart = 0;
		int windowEnd = 0;
		int maxLength = Integer.MIN_VALUE;
		while (windowEnd < arr.length) {
			if (arr[windowEnd] == 0) {
				zeroCount++;
			}
			if (zeroCount > k) {
				while (zeroCount != k) {
					if (arr[windowStart] == 0) {
						zeroCount--;
					}
					windowStart++;
				}
			}
			maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
			windowEnd++;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
		int size = 3;
		System.out.println(findLength(arr, size));
	}

}
