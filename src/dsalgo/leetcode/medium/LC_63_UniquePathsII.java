package dsalgo.leetcode.medium;

public class LC_63_UniquePathsII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return findUniquePaths(obstacleGrid, 0, 0);
	}

	public static int findUniquePaths(int[][] matrix, int start, int end) {

		if (matrix.length - 1 == start && end == matrix.length - 1) {
			return 1;
		}

		if (start >= matrix.length || end >= matrix.length || matrix[start][end] == 1) {
			return 0;
		}

		int rightPaths = findUniquePaths(matrix, start + 1, end);
		int downPaths = findUniquePaths(matrix, start, end + 1);
		return rightPaths + downPaths;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(matrix));
	}

}
