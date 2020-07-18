package dsalgo.easy.grokking.dp.lcs;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	public static int getMaximumIncreasingSubsequence(int[] arr, int i, int max, int sum) {
		if (i == arr.length) {
			return sum;
		}
		int whenExcluded = getMaximumIncreasingSubsequence(arr, i + 1, max, sum);
		int whenIncluded = sum;
		if (arr[i] > max) {
			whenIncluded = getMaximumIncreasingSubsequence(arr, i + 1, arr[i], sum + arr[i]);
		}
		return Math.max(whenExcluded, whenIncluded);
	}

	public static int getMaximumIncreasingSubsequenceBottomUp(int arr[]) {
		int[] cache = new int[arr.length];
		cache[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && cache[j] > cache[i]) {
					cache[i] = cache[j];
				}
			}
			cache[i] += arr[i];
		}

		return Arrays.stream(cache).max().getAsInt();
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println(getMaximumIncreasingSubsequence(arr, 0, arr[0], arr[0]));
		System.out.println(getMaximumIncreasingSubsequenceBottomUp(arr));
		
	}

}
