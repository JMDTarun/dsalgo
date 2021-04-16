package dsalgo.leetcode.medium;

public class SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int col = findColumn(matrix, m - 1, n - 1, target);
		int row = findRow(matrix, m - 1, n - 1, target, col);
		return !(row == -1);
	}

	private static int findColumn(int[][] matrix, int m, int n, int target) {
		int start = 0;
		int end = n;
		int mid = 0;
		int minValueIndex = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (matrix[0][mid] < target) {
				minValueIndex = mid;
			}
			if (target == matrix[0][mid]) {
				return mid;
			} else if (target < matrix[0][mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return minValueIndex;
	}

	private static int findRow(int[][] matrix, int m, int n, int target, int col) {
		int start = 0;
		int end = m;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid <= m) {
				if (target == matrix[mid][col]) {
					return mid;
				} else if (target < matrix[mid][col]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				return -1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

//		[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
//				19

//		int[][] matrix = { { 1, 4 }, { 2, 5 } };

		System.out.println(searchMatrix(matrix, 19));

	}

}
