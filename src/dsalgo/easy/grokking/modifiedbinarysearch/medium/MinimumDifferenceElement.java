package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class MinimumDifferenceElement {

//	Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
//
//	Example 1:
//
//	Input: [4, 6, 10], key = 7
//	Output: 6
//	Explanation: The difference between the key '7' and '6' is minimum than any other number in the array 
//	Example 2:
//
//	Input: [4, 6, 10], key = 4
//	Output: 4
//	Example 3:
//
//	Input: [1, 3, 8, 10, 15], key = 12
//	Output: 10
//	Example 4:
//
//	Input: [4, 6, 10], key = 17
//	Output: 10

	public static int searchMinDiffElement(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int minDiff = Integer.MAX_VALUE;
		int minIndex = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (minDiff > Math.abs(arr[mid] - key)) {
				minDiff = Math.abs(arr[mid] - key);
				minIndex = mid;
			}
			if (arr[mid] == key) {
				minDiff = 0;
				minIndex = mid;
				return minDiff;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return arr[minIndex];
	}

	public static void main(String[] args) {
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
		System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
	}

}
