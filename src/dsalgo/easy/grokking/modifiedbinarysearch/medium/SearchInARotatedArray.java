package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class SearchInARotatedArray {

	public static int search(int nums[], int target) {
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
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int searchNew(int nums[], int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (target > nums[mid] && target > nums[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int searchMin(int nums[]) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (start + (end - start) / 2);
			if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		System.out.println(nums[end]);
		return -1;
	}

	public static int searchTarget(int nums[], int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (start + (end - start) / 2);
			if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		System.out.println(nums[end]);
		return -1;
	}

	
	public static void main(String[] args) {

		System.out.println(searchMin(new int[] { 10, 15, 1, 3, 8 }));
		System.out.println(searchMin(new int[] { 10, 11, 12, 13, 14, 15, 1, 3, 8 }));
		System.out.println(searchMin(new int[] { 4, 5, 7, 9, 10, -1, 2 }));

		// System.out.println(searchNew(new int[] { 10, 15, 1, 3, 8 }, 15));
		// System.out.println(searchNew(new int[] { 10, 11, 12, 13, 14, 15, 1, 3, 8 },
		// 3));
		// System.out.println(searchNew(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	}

}
