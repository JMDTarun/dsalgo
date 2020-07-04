package dsalgo.easy.grokking.dp.knapsack.medium;

import dsalgo.common.AlgoUtil;

public class Knapsack {

	private static void solveKnapsack(int[] weights, int[] profits, int capacity) {
		int[][] arr = new int[profits.length + 1][capacity + 1];
		AlgoUtil.print2D(arr);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (weights[i - 1] > j) {
					arr[i][j] = arr[i - 1][j];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], profits[i - 1] + arr[i - 1][j - weights[i - 1]]);
				}
				AlgoUtil.print2D(arr);
			}
		}
		AlgoUtil.print2D(arr);
	}

	private static int knapsackBottomUp(int[] wt, int profit[], int capacity) {
		int[] maxProfit = new int[capacity + 1];
		for (int i = 1; i <= capacity; i++) {
			for (int j = 1; j < wt.length; j++) {
				if (j >= wt[i - 1]) {
					maxProfit[i] = (wt[i - 1] > j) ? maxProfit[j - 1]
							: Math.max(maxProfit[j - 1], maxProfit[j - wt[i - 1]] + profit[i - 1]);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] profits = { 1, 4, 5, 7 };
		int[] weights = { 1, 3, 4, 5 };
		int capacity = 7;
		solveKnapsack(weights, profits, capacity);
		knapsackBottomUp(weights, profits, 7);
	}

}
