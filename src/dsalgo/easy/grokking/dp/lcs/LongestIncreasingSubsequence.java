package dsalgo.easy.grokking.dp.lcs;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int longestIncreasingSubsequence(int[] arr, int i, int n, int prev) {
		if (i == n) {
			return 0;
		}
		int excl = longestIncreasingSubsequence(arr, i + 1, n, prev);
		int incl = 0;
		if (arr[i] > prev) {
			incl = 1 + longestIncreasingSubsequence(arr, i + 1, n, arr[i]);
		}
		return Integer.max(incl, excl);
	}

	public static int longestIncreasingSubsequenceBottomUp(int[] arr) {
		int cache[] = new int[arr.length];
		cache[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && cache[i] < cache[j]) {
					cache[i] = cache[j];
				}
			}
			cache[i]++;
		}
		return Arrays.stream(cache).max().getAsInt();
	}
	
	public static int longestIncreasingSubsequenceTopDown(int[] A) {
		int[] dp = new int[A.length];
		return doLongestIncreasingSubsequenceTopDown(A, A.length - 1, dp);
	}

	private static int doLongestIncreasingSubsequenceTopDown(int[] A, int i, int[] dp) {
		if (i == 0) {
			return 1;
		}
		if (dp[i] != 0) {
			return dp[i];
		}

		int max = 1;
		for (int j = 0; j < i; j++) {
			int lis = doLongestIncreasingSubsequenceTopDown(A, j, dp);
			// We can have 2 possibilities:
			// 1. Increasing subsequence ending at i (i.e., ith element is part of
			// subsequence)
			// 2. Increasing subsequence not ending at i (i.e., ith element is not included
			// in subsequence)
			if (A[i] > A[j]) {  // If true, ith element is part of subsequence hence increment result by 1
				lis += 1;
			}
			max = Math.max(max, lis);
		}

		dp[i] = max;
		return max;
	}
	public static void main(String[] args) {
		int arr[] = new int[] { 5,2,4,7,3,8,2 };
		System.out.println(longestIncreasingSubsequence(arr, 0, arr.length, Integer.MIN_VALUE));
		System.out.println(longestIncreasingSubsequenceBottomUp(arr));
	}

}
