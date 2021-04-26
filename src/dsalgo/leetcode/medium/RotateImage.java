package dsalgo.leetcode.medium;

public class RotateImage {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;

		// flip the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// reverse row
		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = matrix[i].length - 1;

			while (start < end) {
				int temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;
				start++;
				end--;
			}

		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix);
	}

}
