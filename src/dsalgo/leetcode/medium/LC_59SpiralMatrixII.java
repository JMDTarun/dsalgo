package dsalgo.leetcode.medium;

public class LC_59SpiralMatrixII {

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int firstRow = 0;
		int lastColumn = n - 1;
		int lastRow = n - 1;
		int firstCoumn = 0;

		int counter = 1;
		while (firstRow <= lastColumn) {

			for (int i = firstRow; i <= lastColumn; i++) {
				matrix[firstRow][i] = counter;
				counter++;
			}
			firstRow++;
			for (int i = firstRow; i <= lastRow; i++) {
				matrix[i][lastColumn] = counter;
				counter++;
			}
			lastColumn--;

			for (int i = lastColumn; i >= firstCoumn; i--) {
				matrix[lastRow][i] = counter;
				counter++;
			}
			lastRow--;

			for (int i = lastRow; i >= firstRow; i--) {
				matrix[i][firstCoumn] = counter;
				counter++;
			}
			firstCoumn++;
		}

		return matrix;
	}

	public static void main(String[] args) {
		generateMatrix(4);
	}

}
