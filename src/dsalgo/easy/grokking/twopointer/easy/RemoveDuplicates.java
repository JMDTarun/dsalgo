package dsalgo.easy.grokking.twopointer.easy;

public class RemoveDuplicates {

	// Given an array of sorted numbers, remove all duplicates from it. You should
	// not use any extra space; after removing the duplicates in-place return the
	// new length of the array.

	// Input: [2, 3, 3, 3, 6, 9, 9]
	// Output: 4
	// Explanation: The first four elements after removing the duplicates will be
	// [2, 3, 6, 9].
	//
	// Input: [2, 2, 2, 11]
	// Output: 2
	// Explanation: The first two elements after removing the duplicates will be [2,
	// 11].

	public static int remove(int[] arr) {
		int arrSize = 1;
		int startPointer = 1;
		int i = 1;
		while (i < arr.length) {
			if (arr[i] != arr[i - 1]) {
				arrSize++;
				arr[startPointer] = arr[i];
				startPointer++;
			} 
			i++;
		}
		return arrSize;
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(remove(arr));
	}

}
