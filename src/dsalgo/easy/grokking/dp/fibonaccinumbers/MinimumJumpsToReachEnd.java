package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class MinimumJumpsToReachEnd {

	public static int minJumps(int arr[], int index, int[] cache) {
		if (index >= arr.length - 1) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		if (cache[index] != Integer.MAX_VALUE) {
			return cache[index];
		}
		for (int i = index; i <= arr[index]; i++) {
			if (index < arr.length) {
				int jumps = minJumps(arr, i + 1, cache);
				if (jumps != Integer.MAX_VALUE) {
					min = Math.min(min, 1 + jumps);
				}
			}
		}
		cache[index] = min;
		return cache[index];
	}

	public static int minJumps(int arr[], int l, int h, Integer[] cache) {
		if (h == l) {
			return 0;
		}
		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}

		if (cache[l] != null) {
			return cache[l];
		}

		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumps(arr, i, h, cache);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		cache[l] = min;
		return min;
	}

	public static int minimumJumps(int nums[]) {
		Integer[] minJumps = new Integer[nums.length];
		minJumps[nums.length - 1] = 0;

		for (int i = nums.length - 2; i >= 0; i--) {
			Integer min = Integer.MAX_VALUE;
			for (int j = i; j < i + nums[i]; j++) {
				if (i + nums[i] < nums.length - 1) {
					if (minJumps[j + 1] != Integer.MAX_VALUE) {
						min = Math.min(min, minJumps[j + 1] + 1);
					}
				} else {
					min = Math.min(min, minJumps[nums.length - 1] + 1);
					break;
				}
			}
			minJumps[i] = min;
		}
		return minJumps[0];
	}

	public static int minJumpsBottomUp(int arr[]) {
		int[] matrix = new int[arr.length + 1];

		for (int i = 1; i <= arr.length; i++) {
			matrix[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i <= arr.length; i++) {
			for (int j = i; j < arr.length && j < i + arr[i]; j++) {
				int jumps = matrix[i] + 1;
				if (jumps != Integer.MAX_VALUE) {
					matrix[i + 1] = Math.min(matrix[j + 1], jumps);
				}
			}
		}
		return 0;
	}

	public static int jump(int[] A) {
		if (A.length < 2) {
			return 0;
		}
		final int[] memo = new int[A.length];
		for (int i = A.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int k = 1; k <= A[i]; k++) {
				if (i + k < A.length) {
					min = Math.min(min, 1 + memo[i + k]);
				}
			}
			memo[i] = min;
		}
		return memo[0];
	}

	public static void main(String[] args) {
//		 int[] cache = new int[5];
//		 for (int i = 0; i < cache.length; i++) {
//		 cache[i] = Integer.MAX_VALUE;
//		 }
//		 System.out.println(minJumps(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }, 0, cache));
//		 //System.out.println(minJumpsBottomUp(new int[] { 2, 3, 1, 1, 4 }, 5));
//		 System.out.println(jump(new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }));

		int arr[] = { 2, 3, 0, 1, 4 };
		int n = arr.length;
//		Integer cache[] = new Integer[n];
		// System.out.print("Minimum number of jumps to reach end is " + minJumps(arr,
		// 0, n - 1, cache));
		System.out.println(minimumJumps(arr));
	}

}
