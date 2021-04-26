package dsalgo.easy.grokking.twopointer.medium;

public class DutchNationalFlagProblem {

	// Problem Statement #
	// Given an array containing 0s, 1s and 2s, sort the array in-place. You should
	// treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s
	// to recreate the array.
	//
	// The flag of the Netherlands consists of three colors: red, white and blue;
	// and since our input array also consists of three different numbers that is
	// why it is called Dutch National Flag problem.
	//
	// Example 1:
	//
	// Input: [1, 0, 2, 1, 0]
	// Output: [0 0 1 1 2]
	// Example 2:
	//
	// Input: [2, 2, 0, 1, 2, 0]
	// Output: [0 0 1 2 2 2 ]

	public static void sort(int[] arr) {
		int startPointer = 0;
		int endPointer = 1;
		int flag = 0;
		while (startPointer < arr.length) {
			if (arr[startPointer] != 0) {
				while (endPointer < arr.length) {
					if (arr[endPointer] == flag) {
						int temp = arr[startPointer];
						arr[startPointer] = arr[endPointer];
						arr[endPointer] = temp;
						startPointer++;
					}
					endPointer++;
				}
				endPointer = startPointer + 1;
				flag++;
				if (flag == 2) {
					break;
				}
			} else {
				startPointer++;
				endPointer++;
			}
		}
	}

	public static void sortOptimized(int[] nums) {
		int startPointer = 0;
		int endPointer = nums.length - 1;
		for (int i = 0; i < nums.length && i <= endPointer;) {
			if (nums[i] == 0) {
				int temp = nums[startPointer];
				nums[startPointer] = nums[i];
				nums[i] = temp;
				startPointer++;
				i++;
			} else if (nums[i] == 2) {
				int temp = nums[endPointer];
				nums[endPointer] = nums[i];
				nums[i] = temp;
				endPointer--;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		// int[] arr = { 1, 1, 0, 2, 1, 0, 2, 0, 1 };
		int[] arr = { 1, 0, 2, 1, 0 };
		sortOptimized(arr);
		for (Integer i : arr) {
			System.out.println(i);
		}
	}

}
