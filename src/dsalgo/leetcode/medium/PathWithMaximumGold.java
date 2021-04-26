package dsalgo.leetcode.medium;

public class PathWithMaximumGold {

	public static int getMaximumGold(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int max = Integer.MIN_VALUE;
		boolean[][] seen = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
					max = Math.max(max, getMaximumGoldHelper(grid, seen, i, j, m, n));
				}
			}
		}
		return max;
	}

	private static int getMaximumGoldHelper(int[][] grid, boolean[][] seen, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
			return 0;
		}
		if (seen[i][j] || grid[i][j] == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		seen[i][j] = true;
		max = Math.max(max, grid[i][j] + getMaximumGoldHelper(grid, seen, i, j + 1, m, n));
		max = Math.max(max, grid[i][j] + getMaximumGoldHelper(grid, seen, i, j - 1, m, n));
		max = Math.max(max, grid[i][j] + getMaximumGoldHelper(grid, seen, i - 1, j, m, n));
		max = Math.max(max, grid[i][j] + getMaximumGoldHelper(grid, seen, i + 1, j, m, n));
		seen[i][j] = false;
		return max;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } };
		System.out.println(getMaximumGold(grid));
	}

}
