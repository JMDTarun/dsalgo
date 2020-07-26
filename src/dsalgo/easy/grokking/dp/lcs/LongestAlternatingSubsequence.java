package dsalgo.easy.grokking.dp.lcs;

import java.util.Arrays;

public class LongestAlternatingSubsequence {

	public static int longestAlternatingSubsequenceBottomUp(int[] arr) {
		int[] cache = new int[arr.length];
		cache[0] = 1;
		boolean isDecreasingIncreasing = arr[0] > arr[1];
		boolean isElementFound = false;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isDecreasingIncreasing) {
					if (arr[i] < arr[j] && cache[i] < cache[j]) {
						isElementFound = true;
						cache[i] = cache[j];
					}
				} else {
					if (arr[i] > arr[j] && cache[i] < cache[j]) {
						isElementFound = true;
						cache[i] = cache[j];
					}
				}
			}
			if (isElementFound) {
				isDecreasingIncreasing = !isDecreasingIncreasing;
				isElementFound = false;
			}
			cache[i]++;
		}
		return Arrays.stream(cache).max().getAsInt();
	}

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 49, 50, 31, 60 };
		System.out.println(longestAlternatingSubsequenceBottomUp(arr));
	}

}
