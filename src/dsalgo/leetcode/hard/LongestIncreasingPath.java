package dsalgo.leetcode.hard;

public class LongestIncreasingPath {

	int longestPath = 1;

	public int longestIncreasingPath(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int lp = 1;
		boolean[][] mat = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				traverseMatrix(matrix, i, j, n, m, 1, mat);
				if (lp < longestPath) {
					lp = longestPath;
				}
				longestPath = 0;
			}
		}
		return lp;
	}

	private int traverseMatrix(int[][] matrix, int i, int j, int n, int m, int longest, boolean[][] mat) {
		if (i > n || j > m) {
			return 0;
		}
		mat[i][j] = true;

		if (i - 1 >= 0 && !mat[i - 1][j] && matrix[i][j] < matrix[i - 1][j]) {
			mat[i][j] = true;
			int l = traverseMatrix(matrix, i - 1, j, n, m, longest + 1, mat);
			if (l > longestPath) {
				longestPath = l;
			}
		}

		if (i + 1 < n && !mat[i + 1][j] && matrix[i][j] < matrix[i + 1][j]) {
			int l = traverseMatrix(matrix, i + 1, j, n, m, longest + 1, mat);
			if (l > longestPath) {
				longestPath = l;
			}
		}

		if (j - 1 >= 0 && !mat[i][j - 1] && matrix[i][j] < matrix[i][j - 1]) {
			int l = traverseMatrix(matrix, i, j - 1, n, m, longest + 1, mat);
			if (l > longestPath) {
				longestPath = l;
			}
		}

		if (j + 1 < m && !mat[i][j + 1] && matrix[i][j] < matrix[i][j + 1]) {
			int l = traverseMatrix(matrix, i, j + 1, n, m, longest + 1, mat);
			if (l > longestPath) {
				longestPath = l;
			}
		}
		mat[i][j] = false;
		return longest;
	}

	public static void main(String[] args) {
//		int matrix[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		int matrix[][] = { { 9, 9 }, { 6, 6 }, { 2, 1 } };
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
//		int matrix[][] = { { 1 } };
//		LongestIncreasingPath lip = new LongestIncreasingPath();
//		System.out.println(lip.longestIncreasingPath(matrix));
	}

}
