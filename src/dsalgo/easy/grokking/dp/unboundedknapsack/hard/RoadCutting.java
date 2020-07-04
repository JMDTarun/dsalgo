package dsalgo.easy.grokking.dp.unboundedknapsack.hard;

public class RoadCutting {

	// Given a rod of length n inches and an array of prices that contains prices of
	// all pieces of size smaller than n. Determine the maximum value obtainable by
	// cutting up the rod and selling the pieces. For example, if length of the rod
	// is 8 and the values of different pieces are given as following, then the
	// maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
	//
	//
	// length | 1 2 3 4 5 6 7 8
	// --------------------------------------------
	// price | 1 5 8 9 10 17 17 20
	// And if the prices are as following, then the maximum obtainable value is 24
	// (by cutting in eight pieces of length 1)
	//
	// length | 1 2 3 4 5 6 7 8
	// --------------------------------------------
	// price | 3 5 8 9 10 17 17 20

	public static int findMaxProfit(int[] price, int l) {
		if (l == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < l; i++) {
			max = Math.max(price[i] + findMaxProfit(price, l - i - 1), max);
		}
		return max;
	}

	public static int roadCuttingBottomUp(int[] profit, int length) {
		int[] maxProfit = new int[length + 1];
		for (int i = 1; i <= length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max, maxProfit[j - 1] + profit[i - j]);
			}
			maxProfit[i] = max;
		}
		return maxProfit[length];
	}

	public static int roadCuttingDp(int[] length, int[] profit) {
		int[][] t = new int[length.length + 1][profit.length + 1];
		for (int i = 1; i <= length.length; i++) {
			for (int j = 1; j <= profit.length; j++) {
				if (length[i - 1] <= j) {
					t[i][j] = Math.max(profit[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[length.length][profit.length];
	}

	public static void main(String[] args) {
		int[] price = new int[] { 3, 5, 8 };
		int[] length = new int[] { 1, 2, 3 };
		// System.out.println(findMaxProfit(price, 3));
		// System.out.println(roadCuttingDp(length, price));
		System.out.println(roadCuttingBottomUp(price, 3));
	}

}
