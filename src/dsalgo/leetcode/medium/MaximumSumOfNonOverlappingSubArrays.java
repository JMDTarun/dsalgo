package dsalgo.leetcode.medium;

public class MaximumSumOfNonOverlappingSubArrays {

	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int n = A.length;
		int[] preSum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			preSum[i + 1] = A[i] + preSum[i];
		}
		int lMax = preSum[L], mMax = preSum[M];
		int res = preSum[L + M];
		for (int j = 0; j < preSum.length; j++) {
			if (preSum[j] > 9) {
				System.out.print(" ");
			}
			System.out.print(j + ",");
		}
		System.out.println();
		for (int j = 0; j < preSum.length; j++) {
			System.out.print(preSum[j] + ",");
		}
		System.out.println();
		for (int i = L + M; i <= n; i++) {
			// case 1: L subarray is always before M subarray
			System.out.println("1st Case: " + lMax + " preSum[i - M]:preSum[" + i + " - " + M + "]:" + preSum[i - M]
					+ " - preSum[i-M-L]:preSum[" + i + " - " + M + "- " + L + "]:" + preSum[i - M - L]);
			lMax = Math.max(lMax, preSum[i - M] - preSum[i - M - L]);
			// case 2: M subarray is always before L subarray
			System.out.println("2nd Case: " + mMax + " preSum[i - L]:preSum[" + i + " - " + L + "]:" + preSum[i - L]
					+ " - preSum[i-M-L]:preSum[" + i + " - " + M + "- " + L + "]:" + preSum[i - M - L]);
			mMax = Math.max(mMax, preSum[i - L] - preSum[i - M - L]);
			// compare two cases and update res
			res = Math.max(res, Math.max(lMax + preSum[i] - preSum[i - M], mMax + preSum[i] - preSum[i - L]));
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 6, 5, 2, 2, 5, 1, 9, 4 };
		maxSumTwoNoOverlap(nums, 3, 2);
	}

}
