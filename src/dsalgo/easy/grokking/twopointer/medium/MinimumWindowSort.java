package dsalgo.easy.grokking.twopointer.medium;

public class MinimumWindowSort {

	// Minimum Window Sort (medium) #
	// Given an array, find the length of the smallest subarray in it which when
	// sorted will sort the whole array.
	//
	// Example 1:
	//
	// Input: [1, 2, 5, 3, 7, 10, 9, 12]
	// Output: 5
	// Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the
	// whole array sorted
	// Example 2:
	//
	// Input: [1, 3, 2, 0, -1, 7, 10]
	// Output: 5
	// Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the
	// whole array sorted
	// Example 3:
	//
	// Input: [1, 2, 3]
	// Output: 0
	// Explanation: The array is already sorted
	// Example 4:
	//
	// Input: [3, 2, 1]
	// Output: 3
	// Explanation: The whole array needs to be sorted.

	public static int sort(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (Integer i : arr) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		int startPointer = 0;
		int endPointer = arr.length - 1;
		int sortingRequiredFromStart = -1;
		int sortingRequiredFromEnd = -1;
		while (startPointer < endPointer) {
			if (sortingRequiredFromStart < 0 && arr[startPointer] <= min && arr[startPointer] < arr[startPointer + 1]) {
				startPointer++;
			} else {
				sortingRequiredFromStart = startPointer;
			}
			if (sortingRequiredFromEnd < 0 && arr[endPointer] >= max && arr[endPointer] > arr[endPointer - 1]) {
				endPointer--;
			} else {
				sortingRequiredFromEnd = endPointer;
			}
			if (sortingRequiredFromEnd > -1 && sortingRequiredFromStart > -1) {
				break;
			}
		}
		if (sortingRequiredFromEnd == -1 && sortingRequiredFromStart == -1) {
			return 0;
		} else if (sortingRequiredFromStart == 0 && sortingRequiredFromEnd == arr.length - 1) {
			return (sortingRequiredFromEnd - sortingRequiredFromStart) + 1;
		}
		return (sortingRequiredFromEnd - sortingRequiredFromStart);
	}

	public static void main(String[] args) {
		System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println(sort(new int[] { 1, 2, 3 }));
		System.out.println(sort(new int[] { 3, 2, 1 }));
		System.out.println(sort(new int[] { 1, 2, 12, 10, 6, 15, 18, 3 }));
	}

}
