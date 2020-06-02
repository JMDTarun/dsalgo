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

	public static void main(String[] args) {
		int[] profits = { 1, 4, 5, 7 };
		int[] weights = { 1, 3, 4, 5 };
		int capacity = 7;
		solveKnapsack(weights, profits, capacity);
	}

}
