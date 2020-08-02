package dsalgo.easy.algoexpert.medium;

public class MaxSubsetSumNoAdjacent {

	public static int getMaxSubSetNoAdjacent(Integer[] cache, int arr[], int i) {
		if (i > arr.length - 1) {
			return 0;
		}
		if (cache[i] != null && cache[i] > 0) {
			return cache[i];
		}
		int max = Integer.MIN_VALUE;
		for (int k = i; k < arr.length; k++) {
			max = Math.max(max, arr[k] + getMaxSubSetNoAdjacent(cache, arr, k + 2));
		}
		cache[i] = max;
		return cache[i];
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		Integer[] cache = new Integer[arr.length + 1];
		System.out.println(getMaxSubSetNoAdjacent(cache, arr, 0));
	}

}
