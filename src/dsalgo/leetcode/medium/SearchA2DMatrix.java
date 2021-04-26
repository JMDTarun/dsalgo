package dsalgo.leetcode.medium;

public class SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int row = mid / n;
			int col = mid % n;

			if (matrix[row][col] == target) {
				return true;
			} else if (target < matrix[row][col]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1 } };

//		[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
//				19

//		int[][] matrix = { { 1, 4 }, { 2, 5 } };

		System.out.println(searchMatrix(matrix, 13));

	}

}
