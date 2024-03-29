package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class SearchInASortedInfiniteArray {

	// Problem Statement #
	// Given an infinite sorted array (or an array with unknown size), find if a
	// given number ‘key’ is present in the array. Write a function to return the
	// index of the ‘key’ if it is present in the array, otherwise return -1.
	//
	// Since it is not possible to define an array with infinite (unknown) size, you
	// will be provided with an interface ArrayReader to read elements of the array.
	// ArrayReader.get(index) will return the number at index; if the array’s size
	// is smaller than the index, it will return Integer.MAX_VALUE.
	//
	// Example 1:
	//
	// Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
	// Output: 6
	// Explanation: The key is present at index '6' in the array.
	// Example 2:
	//
	// Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
	// Output: -1
	// Explanation: The key is not present in the array.
	// Example 3:
	//
	// Input: [1, 3, 8, 10, 15], key = 15
	// Output: 4
	// Explanation: The key is present at index '4' in the array.
	// Example 4:
	//
	// Input: [1, 3, 8, 10, 15], key = 200
	// Output: -1
	// Explanation: The key is not present in the array.

	public static int search(ArrayReader arrayReader, int value) {
		int startIndex = 0;
		int endIndex = 1;
		while (startIndex < endIndex) {
			int mid = (startIndex + endIndex) / 2;
			if (arrayReader.get(mid) == Integer.MAX_VALUE) {
				endIndex = mid - 1;
			} else if (arrayReader.get(mid) == value) {
				return mid;
			} else if (arrayReader.get(mid) > value) {
				endIndex = mid - 1;
			} else {
				if (endIndex > startIndex) {
					endIndex = (2 * endIndex);
				}
				startIndex = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayReader arrayReader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		System.out.println(search(arrayReader, 16));
		System.out.println(
				search(new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 }), 11));
		System.out.println(search(new ArrayReader(new int[] { 1, 3, 8, 10, 15 }), 15));
		System.out.println(search(new ArrayReader(new int[] { 1, 3, 8, 10, 15 }), 200));
	}

}

class ArrayReader {
	int[] array;

	public ArrayReader(int[] arr) {
		this.array = arr;
	}

	public int get(int index) {
		if (index >= array.length) {
			return Integer.MAX_VALUE;
		}
		return array[index];
	}
}