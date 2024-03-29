package dsalgo.easy.grokking.dp.knapsack.medium;

import dsalgo.common.AlgoUtil;

public class SubsetSum {
	public static boolean isSubsetExistWithSum(int[] arr, int sum) {
		int matrix[][] = new int[arr.length + 1][sum + 1];
//		AlgoUtil.print2D(matrix);
		boolean isSubsetExistWithSum = false;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (arr[i - 1] > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], arr[i - 1] + matrix[i - 1][j - arr[i - 1]]);
					if (matrix[i][j] == sum) {
						isSubsetExistWithSum = true;
						break;
					}
				}
			}
			//AlgoUtil.print2D(matrix);
			if (isSubsetExistWithSum) {
				break;
			}
		}
		return isSubsetExistWithSum;
	}

	
	
	public static void main(String[] args) {
		System.out.println(isSubsetExistWithSum(new int[] { 1, 2, 3, 7 }, 6));
		System.out.println(isSubsetExistWithSum(new int[] { 1, 2, 7, 1, 5 }, 10));
		System.out.println(isSubsetExistWithSum(new int[] { 1, 3, 4, 8 }, 6));
	}
}
