package dsalgo.easy.grokking.dp.knapsack.hard;

public class TargetSum {

	// Target Sum (hard) #
	// You are given a set of positive numbers and a target sum ‘S’. Each number
	// should be assigned either a ‘+’ or ‘-’ sign. We need to find the total ways
	// to assign symbols to make the sum of the numbers equal to the target ‘S’.
	//
	// Example 1: #
	// Input: {1, 1, 2, 3}, S=1
	// Output: 3
	// Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} &
	// {-1+1-2+3} & {+1+1+2-3}
	// Example 2: #
	// Input: {1, 2, 7, 1}, S=9
	// Output: 2
	// Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} &
	// {-1+2+7+1}

	public static int findTargetSubsets(Integer[][] dp, int[] num, int sum, int k, int n) {
		if (sum == k && n == num.length) {
			return 1;
		}
		if (n >= num.length) {
			return 0;
		}
		int totalSum = 0;
		for (int i = 0; i < num.length; i++) {
			totalSum = findTargetSubsets(dp, num, sum + num[n], k, n + 1)
					+ findTargetSubsets(dp, num, sum - num[n], k, n + 1);
		}
		return totalSum;
	}

	public static int findTargetSubsets(int[] num, int s) {
		Integer[][] dp = new Integer[num.length][s + 1];
		return findTargetSubsets(dp, num, 0, s, 0);
	}

	public static void main(String[] args) {
		System.out.println(findTargetSubsets(new int[] { 1, 1, 2, 3 }, 1));
		System.out.println(findTargetSubsets(new int[] { 1, 2, 7, 1 }, 9));
	}

}
