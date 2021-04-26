package dsalgo.leetcode.medium;

public class SortColors {

	public void sortColors(int[] nums) {
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

	}

}
