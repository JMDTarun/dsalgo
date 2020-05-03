package dsalgo.easy.grokking.modifiedbinarysearch.easy;

public class OrderAgnosticBinarySearch {

	// Problem Statement #
	// Given a sorted array of numbers, find if a given number ‘key’ is present in
	// the array. Though we know that the array is sorted, we don’t know if it’s
	// sorted in ascending or descending order. You should assume that the array can
	// have duplicates.
	//
	// Write a function to return the index of the ‘key’ if it is present in the
	// array, otherwise return -1.
	//
	// Example 1:
	//
	// Input: [4, 6, 10], key = 10
	// Output: 2
	// Example 2:
	//
	// Input: [1, 2, 3, 4, 5, 6, 7], key = 5
	// Output: 4
	// Example 3:
	//
	// Input: [10, 6, 4], key = 10
	// Output: 0
	// Example 4:
	//
	// Input: [10, 6, 4], key = 4
	// Output: 2

	public static int search(int[] arr, int key) {
		boolean isAscendingOrder = true;
		int index = -1;
		int left = 0;
		int right = arr.length - 1;
		if (arr[0] == arr[arr.length - 1]) {
			if (arr[0] == key) {
				return 0;
			}
		} else if (arr[0] > arr[arr.length - 1]) {
			isAscendingOrder = false;
		}

		while (left <= right) {
			int idx = (left + right) / 2;
			if (arr[idx] == key) {
				return idx;
			} else if (arr[idx] < key) {
				if (isAscendingOrder) {
					left = idx + 1;
				} else {
					right = idx - 1;
				}
			} else {
				if (isAscendingOrder) {
					right = idx - 1;
				} else {
					left = idx + 1;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 6, 4 };
		System.out.println(search(arr, 4));
	}

}
