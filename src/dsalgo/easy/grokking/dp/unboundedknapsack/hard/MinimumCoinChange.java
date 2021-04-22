package dsalgo.easy.grokking.dp.unboundedknapsack.hard;

import java.util.ArrayList;
import java.util.List;

public class MinimumCoinChange {

	// You are given coins of different denominations and a total amount of money
	// amount. Write a function to compute the fewest number of coins that you need
	// to make up that amount. If that amount of money cannot be made up by any
	// combination of the coins, return -1.
	//
	// Example 1:
	//
	// Input: coins = [1, 2, 5], amount = 11
	// Output: 3
	// Explanation: 11 = 5 + 5 + 1
	// Example 2:
	//
	// Input: coins = [2], amount = 3
	// Output: -1

	private static List<Integer> list = new ArrayList<Integer>();
	private static Integer minValue = Integer.MAX_VALUE;

	public static int coinChange(int[] coins, int amount, int minv) {
		if (amount == 0) {
			System.out.println(list);
			minValue = Math.min(minValue, minv);
			return 1;
		}
		if (amount < 0) {
			return 0;
		}
		int min = 0;
		for (int i = 0; i < coins.length; i++) {
			minv++;
			list.add(coins[i]);
			min = Math.min(min, coins[i] + coinChange(coins, amount - coins[i], minv));
			minv--;
			list.remove(list.size() - 1);
		}
		return minValue;
	}

	public static int coinChangeTopDown(int[] sizes, int value) {
		int[] matrix1 = new int[value + 1];

		for (int i = 1; i <= value; i++) {
			matrix1[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= value; i++) {
			for (int j = 0; j < sizes.length; j++) {
				if (i >= sizes[j]) {
					int min = matrix1[i - sizes[j]];
					if (min != Integer.MAX_VALUE) {
						matrix1[i] = Math.min(matrix1[i], 1 + min);
					}
				}
			}
		}
		return matrix1[value] == Integer.MAX_VALUE ? -1 : matrix1[value];
	}

	public static int coinChangeBottomUp(int[] coins, int sum) {
		int[] minCoins = new int[sum + 1];
		for (int i = 1; i <= sum; i++) {
			minCoins[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= sum; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					min = Math.min(minCoins[i], minCoins[i - coins[j]]);
				}
			}
			minCoins[i] = min + 1;
		}
		return minCoins[sum];
	}

	public static void main(String[] args) {
		// System.out.println(coinChange(new int[] { 1, 2, 5 }, 4, 0));
		// System.out.println(coinChangeTopDown(new int[] { 1, 2, 5 }, 8));
		System.out.println(coinChangeBottomUp(new int[] { 1, 2, 3 }, 10));
	}

}
