package dsalgo.leetcode.medium;

public class PerfectSquares {

	public static int numSquares(int n) {
        if (n == 0) {
			return 0;
		}
		Integer arr[] = new Integer[n + 1];
		arr[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (arr[i] == null) {
					arr[i] = Integer.MAX_VALUE;
				}
				arr[i] = Math.min(arr[i], 1 + arr[i - (j * j)]);
			}

		}
		return arr[n];
    }
	
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	
}
