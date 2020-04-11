package dsalgo.easy.grokking.slidingwindow.easy;

public class SmallestSubarrayWithAGivenSum {

	// Given an array of positive numbers and a positive number ‘S’, find the length
	// of the smallest contiguous subarray whose sum is greater than or equal to
	// ‘S’. Return 0, if no such subarray exists.

	// Input: [2, 1, 5, 2, 3, 2], S=7
	// Output: 2
	// Explanation: The smallest subarray with a sum great than or equal to '7' is
	// [5, 2].

	// Input: [2, 1, 5, 2, 8], S=7
	// Output: 1
	// Explanation: The smallest subarray with a sum greater than or equal to '7' is
	// [8].

	private int findSmallestSubArrayWithSum(int[] arr, int value) {
		int smallestSoFar = Integer.MAX_VALUE;
		int j = 0;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= value) {
				smallestSoFar = 1;
				break;
			} else {
				sum += arr[i];
				if (sum >= value) {
					if ((i - j) + 1 < smallestSoFar) {
						smallestSoFar = (i - j) + 1;
					}
					while (sum >= value) {
						sum -= arr[j];
						j++;
						if (sum >= value && (i - j) + 1 < smallestSoFar) {
							smallestSoFar--;
						}
					}
				}
			}
		}
		return smallestSoFar;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 4, 1, 1, 6 };
		int value = 8;

		SmallestSubarrayWithAGivenSum smallestSubarrayWithAGivenSum = new SmallestSubarrayWithAGivenSum();
		int smallestArray = smallestSubarrayWithAGivenSum.findSmallestSubArrayWithSum(arr, value);
		System.out.println(smallestArray);

	}

}
