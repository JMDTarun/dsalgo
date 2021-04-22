package dsalgo.leetcode.medium;

public class CombinationSumIV {

	public static int combinationSum4(int[] nums, int target) {
		int[] cache = new int[target + 1];
		int count = getCount(nums, target, 0, cache);
		return count;
	}

	private static int getCount(int[] nums, int target, int sum, int[] cache) {
		if (sum > target) {
			return 0;
		}

		if (cache[sum] > 0) {
			return cache[sum];
		}

		if (sum == target) {
			return 1;
		}

		int totalCount = 0;
		for (int i = 0; i < nums.length; i++) {
			totalCount += getCount(nums, target, sum + nums[i], cache);
		}
		cache[sum] = totalCount;
		return totalCount;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5 };
		int target = 11;
		System.out.println(combinationSum4(nums, target));
	}

}
