package dsalgo.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LC_41_FirstMissingPositive {

	public static int findFirstMissingPositiveNumber(int[] arr) {
		if (arr.length == 0) {
			return 1;
		}

		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<Integer>();

		for (Integer val : arr) {
			if (val >= 0) {
				min = Math.min(min, val);
				set.add(val);
			}
		}

		if (min > 1) {
			return 1;
		}

		while (true) {
			min++;
			if (!set.contains(min)) {
				break;
			}
		}
		return min;
	}

	public static int findFirstMissingPositiveNumberSolution2(int[] arr) {
		int i = 0;
		int n = arr.length;
		while (i < n) {
			if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
				swap(arr, i, arr[i] - 1);
			} else {
				i++;
			}
		}

		for (i = 0; i < n; i++) {
			if (arr[i] != i + 1)
				return i + 1;
		}

		return n + 1;

	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(findFirstMissingPositiveNumberSolution2(new int[] { 3, 4, -1, 1 }));
	}

}
