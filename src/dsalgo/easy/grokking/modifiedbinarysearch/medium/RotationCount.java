package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class RotationCount {

	// Given an array of numbers which is sorted in ascending order and is rotated
	// �k� times around a pivot, find �k�.
	//
	// You can assume that the array does not have any duplicates.
	//
	// Example 1:
	//
	// Input: [10, 15, 1, 3, 8]
	// Output: 2
	// Explanation: The array has been rotated 2 times.

	// Example 2:
	//
	// Input: [4, 5, 7, 9, 10, -1, 2]
	// Output: 5
	// Explanation: The array has been rotated 5 times.

	public static int search(int arr[], int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			} else if (mid > start && arr[mid - 1] > arr[mid]) {
				return mid;
			}
			if (arr[start] < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 10, 15, 1, 3, 8 }, 15));
		System.out.println(search(new int[] { 10, 11, 12, 13, 14, 15, 1, 3, 8 }, 3));
		System.out.println(search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	}

}
