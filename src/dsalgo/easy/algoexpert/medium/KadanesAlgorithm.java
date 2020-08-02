package dsalgo.easy.algoexpert.medium;

public class KadanesAlgorithm {

	public static int findMaxSumSubarray(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];

		dp[0] = arr[0];

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], 0) + arr[i];
			answer = Math.max(answer, dp[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(findMaxSumSubarray(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
	}
}
