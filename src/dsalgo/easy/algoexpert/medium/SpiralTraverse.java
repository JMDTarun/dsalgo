package dsalgo.easy.algoexpert.medium;

public class SpiralTraverse {

	public static void traverseSpiralMatrix(int[][] matrix) {
		int firstRow = 0;
		int lastColumn = matrix.length;
		int lastRow = matrix.length;
		int firstColumn = 0;

		while (firstRow < lastColumn) {
			for (int i = firstRow; i < lastColumn; i++) {
				System.out.print(matrix[firstRow][i] + ",");
			}
			firstRow++;
			for (int j = firstRow; j < lastColumn; j++) {
				System.out.print(matrix[j][lastColumn - 1] + ",");
			}
			lastColumn--;
			for (int j = lastColumn - 1; j >= firstColumn; j--) {
				System.out.print(matrix[lastColumn][j] + ",");
			}
			lastColumn--;
			for (int i = lastRow - 1; i >= firstRow; i--) {
				System.out.print(matrix[i][firstColumn] + ",");
			}
			firstColumn++;
		}

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		traverseSpiralMatrix(matrix);
	}

}
