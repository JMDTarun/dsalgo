package dsalgo.easy.grokking.dp.unboundedknapsack.hard;

public class CoinChange {

	// Given a value N, if we want to make change for N cents, and we have infinite
	// supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
	// make the change? The order of coins doesn’t matter.
	// For example, for N = 4 and S = {1,2,3}, there are four solutions:
	// {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2,
	// 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}
	// and {5,5}. So the output should be 5.

	public static int coinChange(Integer[][] dp, int sum, int[] coins, int index) {
		if (sum == 0) {
			return 1;
		}
		if (sum < 0) {
			return 0;
		}
		if (index == 0 && sum != 0) {
			return 0;
		}
		if (dp[sum][index] == null) {
			dp[sum][index] = coinChange(dp, sum - coins[index - 1], coins, index)
					+ coinChange(dp, sum, coins, index - 1);
		}
		return dp[sum][index];
	}

	public static int coindChangeTopDown(int[] coins, int sum) {
		int matrix[][] = new int[coins.length + 1][sum + 1];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 1;
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (j < coins[i - 1]) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = matrix[i][j - coins[i - 1]] + matrix[i - 1][j];
				}
			}
		}
		return matrix[coins.length][sum];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		Integer[][] dp = new Integer[5][coins.length + 1];
		System.out.println(coinChange(dp, 4, coins, coins.length));
		System.out.println(coindChangeTopDown(coins, 4));
	}
}
