package dsalgo.easy.grokking.fastandslowpointer.hard;

public class CycleInACircularArray {

	// We are given an array containing positive and negative numbers. Suppose the
	// array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we
	// will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’
	// indices. You should assume that the array is circular which means two things:
	//
	// If, while moving forward, we reach the end of the array, we will jump to the
	// first element to continue the movement.
	// If, while moving backward, we reach the beginning of the array, we will jump
	// to the last element to continue the movement.
	// Write a method to determine if the array has a cycle. The cycle should have
	// more than one element and should follow one direction which means the cycle
	// should not contain both forward and backward movements.
	//
	// Example 1:
	//
	// Input: [1, 2, -1, 2, 2]
	// Output: true
	// Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
	// Example 2:
	//
	// Input: [2, 2, -1, 2]
	// Output: true
	// Explanation: The array has a cycle among indices: 1 -> 3 -> 1
	// Example 3:
	//
	// Input: [2, 1, -1, -2]
	// Output: false
	// Explanation: The array does not have any cycle.

	public static boolean loopExists(int[] arr) {

		int fastPointer = 0;
		int slowPointer = 0;

		do {
			slowPointer = movePointer(slowPointer, arr);
			fastPointer = movePointer(fastPointer, arr);
			fastPointer = movePointer(fastPointer, arr);
		} while (fastPointer != slowPointer);

		boolean isForwardDirection = false;
		if (arr[slowPointer] > 0) {
			isForwardDirection = true;
		}

		int tempPointer = slowPointer;
		int nodeCount = 0;
		do {
			tempPointer = movePointer(tempPointer, arr);
			nodeCount++;
			if (isForwardDirection && arr[tempPointer] < 0) {
				return false;
			} else if (!isForwardDirection && arr[tempPointer] > 0) {
				return false;
			}
		} while (tempPointer != slowPointer);

		if (nodeCount < 2) {
			return false;
		}
		return true;
	}

	private static int movePointer(int pointer, int arr[]) {
		if (pointer + arr[pointer] >= arr.length) {
			pointer = pointer + arr[pointer] - arr.length;
		} else if (pointer + arr[pointer] < 0) {
			pointer = arr.length + arr[pointer];
		} else {
			pointer += arr[pointer];
		}
		return pointer;
	}

	public static void main(String[] args) {
		System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
		System.out.println(loopExists(new int[] { -1, 2 }));
		System.out.println(loopExists(new int[] { -2, 1, -1, -2, -2 }));
		System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
		System.out.println(loopExists(new int[] { 2, -1, 1, 2, 2 }));
		System.out.println(loopExists(new int[] { 1, 2, -1, 2, 2 }));
		System.out.println(loopExists(new int[] { 2, 2, -1, 2 }));
	}

}
