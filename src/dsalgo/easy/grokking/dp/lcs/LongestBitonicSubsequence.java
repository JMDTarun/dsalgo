package dsalgo.easy.grokking.dp.lcs;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	public static int longestBitonicSubsequenceBottomUp(int[] arr) {
		int increasingCache[] = new int[arr.length];
		increasingCache[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && increasingCache[i] < increasingCache[j]) {
					increasingCache[i] = increasingCache[j];
				}
			}
			increasingCache[i]++;
		}

		int decreasingCache[] = new int[arr.length];
		decreasingCache[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && decreasingCache[i] < decreasingCache[j]) {
					decreasingCache[i] = decreasingCache[j];
				}
			}
			decreasingCache[i]++;
		}
		int max = increasingCache[0] + decreasingCache[0] - 1;
		for (int i = 1; i < arr.length; i++) {
			if (increasingCache[i] + decreasingCache[i] - 1 > max) {
				max = increasingCache[i] + decreasingCache[i] - 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 80, 60, 30, 40, 20, 10 };
		System.out.println(longestBitonicSubsequenceBottomUp(arr));
	}

}
