package dsalgo.leetcode.medium;

public class UniquePaths {

	public static int uniquePaths(int m, int n) {
		Integer[][] cache = new Integer[m][n];
		return findUniquePaths(0, 0, m, n, cache);
	}

	public static int findUniquePaths(int start, int end, int m, int n, Integer[][] cache) {

		if (m - 1 == start && end == n - 1) {
			return 1;
		}

		if (start >= m || end >= n) {
			return 0;
		}
		if (cache[start][end] != null) {
			return cache[start][end];
		}
		int rightPaths = findUniquePaths(start + 1, end, m, n, cache);
		int downPaths = findUniquePaths(start, end + 1, m, n, cache);
		int paths = rightPaths + downPaths;
		cache[start][end] = paths;
		return paths;
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
	}

}
