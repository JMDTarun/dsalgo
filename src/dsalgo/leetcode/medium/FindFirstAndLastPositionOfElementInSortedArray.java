package dsalgo.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

	public static int[] searchRange(int[] nums, int target) {
		int[] arr = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return arr;
		}
		int index = binarySearch(nums, target);
		if (index >= 0) {
			int leftIndex = binarySearch(nums, target, index, true);
			int rightIndex = binarySearch(nums, target, index, false);
			arr[0] = leftIndex;
			arr[1] = rightIndex;
		}
		return arr;
	}

	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (target < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	private static int binarySearch(int[] arr, int target, int index, boolean isStart) {
		int start = 0;
		int end = arr.length - 1;

		if (isStart) {
			end = index;
		} else {
			start = index;
		}
		int idx = index;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				idx = mid;
				if (isStart) {
					end = mid;
				} else {
					start = mid;
				}
			}
			if (isStart) {
				if (target <= arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target >= arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}

		return idx;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 7, 7, 7, 8, 8, 8 };
		searchRange(arr, 8);
	}

}
