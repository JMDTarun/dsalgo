package dsalgo.easy.grokking.dp.knapsack.medium;

import dsalgo.common.AlgoUtil;

public class SubsetSum {

	public static boolean canPartition(int[] arr) {
		int sum = 0;
		for (Integer i : arr) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		}
		sum = sum / 2;
		int matrix[][] = new int[arr.length + 1][sum + 1];
		AlgoUtil.print2D(matrix);
		boolean canPartition = false;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (arr[i - 1] > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], arr[i - 1] + matrix[i - 1][j - arr[i - 1]]);
					if (matrix[i][j] == sum) {
						canPartition = true;
						break;
					}
				}
			}
			AlgoUtil.print2D(matrix);
			if (canPartition) {
				break;
			}
		}
		return canPartition;
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 1, 2, 2, 3, 4, 4, 11 }));
	}

}
