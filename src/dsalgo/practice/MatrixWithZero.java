package dsalgo.practice;

import java.util.HashMap;
import java.util.Map;

public class MatrixWithZero {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, -1 }, { -1, 1 } };
		numSubmatrixSumTarget(matrix, 0);
	}

	private static int numSubmatrixSumTarget(int[][] a, int t) {
		int m = a.length, n = a[0].length;
		int[][] preSum = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				preSum[i][j] = preSum[i][j - 1] + a[i][j - 1];
			}
		}
		int count = 0;
		for (int c1 = 0; c1 <= n; c1++) {
			for (int c2 = c1 + 1; c2 <= n; c2++) {
				Map<Integer, Integer> sums = new HashMap<>();
				for (int i = 0, sum = 0, num = 0; i < m; i++) {
					num = preSum[i][c2] - preSum[i][c1];
					sum += num;
					if (sum == t)
						++count;
					count += sums.getOrDefault(sum - t, 0);
					sums.put(sum, sums.getOrDefault(sum, 0) + 1);
				}
			}
		}
		return count;
	}

}
