package dsalgo.easy.grokking.dp.knapsack.hard;

public class CountOfSubsetSum {

	// Given a set of positive numbers, find the total number of subsets whose sum
	// is equal to a given number ‘S’.
	//
	// Example 1: #
	// Input: {1, 1, 2, 3}, S=4
	// Output: 3
	// The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
	// Note that we have two similar sets {1, 3}, because we have two '1' in our
	// input.
	// Example 2: #
	// Input: {1, 2, 7, 1, 5}, S=9
	// Output: 3
	// The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1,
	// 5}

	public static int countSubsets(Integer[][] dp, int[] num, int sum, int k, int n) {
		if (sum == 0) {
			return 1;
		}
		if (n >= num.length) {
			return 0;
		}
		if (dp[n][sum] == null) {
			int sum1 = 0;
			if (num[n] <= sum) {
				sum1 = countSubsets(dp, num, sum - num[n], k, n + 1);
			}
			int sum2 = countSubsets(dp, num, sum, k, n + 1);
			dp[n][sum] = sum1 + sum2;
		}
		return dp[n][sum];
	}

	public static int countSubsetsBottomUp(int num, int sum, int k, int n) {
		return 0;
	}

	public static int countSubsets(int[] num, int k) {
		Integer[][] arr = new Integer[num.length][k + 1];
		return countSubsets(arr, num, k, k, 0);
	}

	public static void main(String[] args) {
		System.out.println(countSubsets(new int[] { 1, 1, 2, 3 }, 4));
		System.out.println(countSubsets(new int[] { 1, 2, 7, 1, 5 }, 9));
	}

}
