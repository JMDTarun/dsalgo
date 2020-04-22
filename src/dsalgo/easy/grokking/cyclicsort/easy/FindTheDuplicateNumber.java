package dsalgo.easy.grokking.cyclicsort.easy;

public class FindTheDuplicateNumber {

	// We are given an unsorted array containing ‘n+1’ numbers taken from the range
	// 1 to ‘n’. The array has only one duplicate but it can be repeated multiple
	// times. Find that duplicate number without using any extra space. You are,
	// however, allowed to modify the input array.
	//
	// Example 1:
	//
	// Input: [1, 4, 4, 3, 2]
	// Output: 4
	// Example 2:
	//
	// Input: [2, 1, 3, 3, 5, 4]
	// Output: 3
	// Example 3:
	//
	// Input: [2, 4, 1, 4, 4]
	// Output: 4

	public static int findNumber(int[] nums) {
		int duplicateNumber = -1;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1) {
				i++;
			} else {
				int temp = nums[i];
				if (temp == nums[temp - 1]) {
					duplicateNumber = temp;
					break;
				} else {
					nums[i] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}
		return duplicateNumber;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 4, 4 };
		System.out.println(findNumber(arr));
	}

}
