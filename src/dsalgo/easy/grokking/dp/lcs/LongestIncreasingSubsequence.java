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

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 6, 1, 2 };
		System.out.println(longestIncreasingSubsequence(arr, 0, arr.length, Integer.MIN_VALUE));
		System.out.println(longestIncreasingSubsequenceBottomUp(arr));
	}

}
