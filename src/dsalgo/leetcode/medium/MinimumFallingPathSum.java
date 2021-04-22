package dsalgo.leetcode.medium;

public class MinimumFallingPathSum {

	public static int minFallingPathSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = m - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				int min = matrix[i + 1][j];

				if (j - 1 >= 0) {
					min = Math.min(min, matrix[i + 1][j - 1]);
				}

				if (j + 1 < n) {
					min = Math.min(min, matrix[i + 1][j + 1]);
				}
				matrix[i][j] += min;
			}
		}
		int min = Integer.MAX_VALUE;
		int[] arr = matrix[0];
		for (int a : arr) {
			min = Math.min(min, a);
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(matrix));
	}

}
