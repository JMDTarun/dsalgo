package dsalgo.leetcode.medium;

public class LC_55_JumpGame {

	public static boolean canJump(int[] nums, int idx) {
		if (idx >= nums.length - 1) {
			return true;
		}
		if (nums[idx] == 0) {
			return false;
		}
		boolean canJump = false;
		for (int i = idx; i < idx + nums[idx]; i++) {
			canJump = canJump(nums, i + nums[i]);
			if (canJump) {
				return true;
			}
		}
		return canJump;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }, 0));
	}

}
