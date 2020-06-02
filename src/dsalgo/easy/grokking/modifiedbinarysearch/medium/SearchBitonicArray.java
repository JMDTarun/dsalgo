package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class SearchBitonicArray {

//	Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
//
//			Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
//
//			Example 1:
//
//			Input: [1, 3, 8, 4, 3], key=4
//			Output: 3
//			Example 2:
//
//			Input: [3, 8, 3, 1], key=8
//			Output: 1
//			Example 3:
//
//			Input: [1, 3, 8, 12], key=12
//			Output: 3
//			Example 4:
//
//			Input: [10, 9, 8], key=10
//			Output: 0

	public static int findMax(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int maxSoFar = -1;
		int maxIndex = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] > maxSoFar) {
				maxSoFar = arr[mid];
				maxIndex = mid;
			}
			if (mid < arr.length - 1 && arr[mid + 1] < maxSoFar) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return maxIndex;
	}

	public static int search(int[] arr, int key) {
		int maxIndex = findMax(arr);
		int index = binarySearch(arr, 0, maxIndex, key);
		if (index != -1) {
			return index;
		}
		return binarySearch(arr, maxIndex + 1, arr.length - 1, key);
	}

	public static int binarySearch(int[] arr, int start, int end, int key) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[start] < arr[end]) {
				if (arr[mid] > key) {
					end = mid - 1;
				} else {
					start = start + 1;
				}
			} else {
				if (arr[mid] > key) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1, 2, 4, 5, 6, 7, 8, 12, 3, 2, 1 }, 3));
		System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
		System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
		System.out.println(search(new int[] { 10, 9, 8 }, 10));
	}

}
