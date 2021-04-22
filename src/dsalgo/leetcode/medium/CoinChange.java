package dsalgo.leetcode.medium;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int result = 0;
		Integer cache[] = new Integer[amount + 1];
		result = coinChange(coins, amount, cache);
		System.out.println(result);
		return result;
	}

	private static int coinChange(int[] coins, int amount, Integer cache[]) {
		if (amount < 0) {
			return Integer.MAX_VALUE;
		}
		if (cache[amount] != null) {
			return cache[amount];
		}
		if (0 == amount) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int t = coinChange(coins, amount - coins[i], cache);
			if (t < min) {
				min = 1 + t;
			}
		}
		cache[amount] = min == Integer.MAX_VALUE ? null : min;
		return min;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5 };
		int sum = 7;
		coinChange(arr, sum);
	}

}
