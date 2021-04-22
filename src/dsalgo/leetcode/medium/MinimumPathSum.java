package dsalgo.leetcode.medium;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
				}
			}
		}

		return grid[m - 1][n - 1];
	}

	public static int minPathSum1(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Integer[][] cache = new Integer[m][n];
		int min = minPathSum(grid, cache, m - 1, n - 1, m, n);
		System.out.println(min);
		return 0;
	}

	public static int minPathSum(int[][] grid, Integer[][] cache, int i, int j, int m, int n) {
		if (i == 0 && j == 0) {
			return grid[i][j];
		}

		if (cache[i][j] != null) {
			return cache[i][j];
		}

		if (i == 0) {
			return grid[i][j] + minPathSum(grid, cache, i, j - 1, m, n);
		}
		if (j == 0) {
			return grid[i][j] + minPathSum(grid, cache, i - 1, j, m, n);
		}
		int val = grid[i][j]
				+ Math.min(minPathSum(grid, cache, i, j - 1, m, n), minPathSum(grid, cache, i - 1, j, m, n));
		cache[i][j] = val;
		return val;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum1(matrix));
	}

}
