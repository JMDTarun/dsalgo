package dsalgo.leetcode.medium;

public class SearchInRotatedSortedArray {

	// [4,5,6,7,0,1,2], 0

	public static int search(int[] nums, int target) {
		int index = -1;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[start] <= nums[mid]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target <= nums[end] && target > nums[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(search(nums, 8));
	}

}
