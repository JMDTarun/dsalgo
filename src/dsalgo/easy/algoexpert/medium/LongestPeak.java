package dsalgo.easy.algoexpert.medium;

public class LongestPeak {

	// Let's call any (contiguous) subarray B (of A) a mountain if the following
	// properties hold:
	//
	// B.length >= 3
	// There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] <
	// B[i] > B[i+1] > ... > B[B.length - 1]
	// (Note that B could be any subarray of A, including the entire array A.)
	//
	// Given an array A of integers, return the length of the longest mountain.
	//
	// Return 0 if there is no mountain.
	//
	// Example 1:
	//
	// Input: [2,1,4,7,3,2,5]
	// Output: 5
	// Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
	// Example 2:
	//
	// Input: [2,2,2]
	// Output: 0
	// Explanation: There is no mountain.

	public static int findLongestPeak(int[] arr) {
		int decreasingCount = 1;
		int increasingCount = 1;
		boolean isIncreasing = false;
		boolean isDecreasing = false;
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				if (isIncreasing && isDecreasing) {
					max = Math.max(max, increasingCount + decreasingCount - 1);
					increasingCount = 1;
					decreasingCount = 1;
					isDecreasing = false;
				}
				increasingCount++;
				isIncreasing = true;
			} else if (isIncreasing && arr[i] < arr[i - 1]) {
				isDecreasing = true;
				decreasingCount++;
			} else {
				if (isIncreasing && isDecreasing) {
					max = Math.max(max, increasingCount + decreasingCount - 1);
				}
				isDecreasing = false;
				isIncreasing = false;
				increasingCount = 1;
				decreasingCount = 1;
			}
		}
		if (isIncreasing && isDecreasing) {
			max = Math.max(max, increasingCount + decreasingCount - 1);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findLongestPeak(new int[] { 2, 1, 4, 7, 3, 2, 5, 6, 4, 3, 2 }));
		System.out.println(findLongestPeak(new int[] { 1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 }));  // 0,10,6,5,-1 = 6
		System.out.println(findLongestPeak(new int[] { 1, 2, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3 }));  // 0,10,6,5,-1 = 6
		System.out.println(findLongestPeak(new int[] { 2, 1, 4, 7, 3, 2, 5 }));  // 1,4,7,3,2 = 5
		System.out.println(findLongestPeak(new int[] { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 })); // all = 11
		System.out.println(findLongestPeak(new int[] { 2, 2, 2 })); // 0
		System.out.println(findLongestPeak(new int[] { 0, 1, 0 })); // all = 3
		System.out.println(findLongestPeak(new int[] { 3, 3, 1 })); // 0

		System.out.println(findLongestPeak(new int[] { 2, 3, 3, 2, 0, 2 })); // 0
		System.out.println(findLongestPeak(new int[] { 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 })); // 0 1 0 = 3
	}

}
