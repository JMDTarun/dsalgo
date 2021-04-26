package dsalgo.leetcode.medium;

public class LC_55_JumpGame {

	public static boolean canJump(int[] nums, int start) {
		if (start > 0 && (start - 1 + nums[start - 1]) >= nums.length - 1) {
			return true;
		}
		if (nums[start] == 0) {
			return false;
		}
		boolean canJump = false;
		for (int i = start; i < nums[start]; i++) {
			canJump = canJump(nums, i + 1);
			if (canJump) {
				return true;
			}
		}
		return canJump;
	}

	public static boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(A[i] + i, max);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }, 0));
	}

}
