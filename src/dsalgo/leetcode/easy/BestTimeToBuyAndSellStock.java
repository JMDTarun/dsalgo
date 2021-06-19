package dsalgo.leetcode.easy;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int profit = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			if (prices[i] - minPrice > profit) {
				profit = prices[i] - minPrice;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(arr));
	}

}
