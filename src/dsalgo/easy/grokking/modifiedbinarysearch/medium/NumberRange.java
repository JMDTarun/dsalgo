package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class NumberRange {

	// Problem Statement #
	// Given an array of numbers sorted in ascending order, find the range of a
	// given number ‘key’. The range of the ‘key’ will be the first and last
	// position of the ‘key’ in the array.
	//
	// Write a function to return the range of the ‘key’. If the ‘key’ is not
	// present return [-1, -1].
	//
	// Example 1:
	//
	// Input: [4, 6, 6, 6, 9], key = 6
	// Output: [1, 3]
	// Example 2:
	//
	// Input: [1, 3, 8, 10, 15], key = 10
	// Output: [3, 3]
	// Example 3:
	//
	// Input: [1, 3, 8, 10, 15], key = 12
	// Output: [-1, -1]

	public static int[] findRange(int[] arr, int key) {
		int[] result = { -1, -1 };
		int startIndex = getIndex(arr, key, true);
		int endIndex = -1;
		if (startIndex != -1) {
			endIndex = getIndex(arr, key, false);
			return new int[] { startIndex, endIndex };
		}

		return result;
	}

	private static int getIndex(int[] arr, int key, boolean isFromStart) {
		int start = 0;
		int end = arr.length - 1;
		int index = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				index = mid;
				if (isFromStart) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] range = findRange(new int[] { 1, 2, 3, 4, 6, 6, 6, 6, 6, 6, 6, 6, 7, 8, 9, 9 }, 6);
		for (Integer i : range) {
			System.out.println(i);
		}
	}

}
