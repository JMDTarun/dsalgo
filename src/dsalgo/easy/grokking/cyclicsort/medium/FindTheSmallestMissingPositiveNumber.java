package dsalgo.easy.grokking.cyclicsort.medium;

public class FindTheSmallestMissingPositiveNumber {

	// Given an unsorted array containing numbers, find the smallest missing
	// positive number in it.
	//
	// Example 1:
	//
	// Input: [-3, 1, 5, 4, 2]
	// Output: 3
	// Explanation: The smallest missing positive number is '3'
	// Example 2:
	//
	// Input: [3, -2, 0, 1, 2]
	// Output: 4
	// Example 3:
	//
	// Input: [3, 2, 5, 1]
	// Output: 4

	public static int findNumber(int[] nums) {

		int startIndex = 0;
		while (startIndex < nums.length) {
			if (nums[startIndex] <= 0 || nums[startIndex] > nums.length) {
				startIndex++;
			} else {
				if (nums[startIndex] == startIndex + 1) {
					startIndex++;
				} else {
					int temp = nums[startIndex];
					nums[startIndex] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findNumber(new int[] { -3, 1, 5, 4, 2 }));
		System.out.println(findNumber(new int[] { 3, -2, 0, 1, 2 }));
		System.out.println(findNumber(new int[] { 3, 2, 5, 1 }));
	}

}
