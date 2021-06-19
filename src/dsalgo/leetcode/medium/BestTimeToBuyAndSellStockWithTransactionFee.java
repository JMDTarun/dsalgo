package dsalgo.leetcode.medium;

public class BestTimeToBuyAndSellStockWithTransactionFee {

	public static int maxProfit(int[] prices, int fee) {

		if (prices == null || prices.length < 2) {
			return 0;
		}

		int sell = 0;
		int buy = sell - prices[0] - fee;

		for (int i = 1; i < prices.length; i++) {
			buy = Math.max(buy, sell - prices[i] - fee);
			sell = Math.max(sell, prices[i] + buy);
		}
		return sell;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 8, 4, 9 };
		maxProfit(arr, 2);
	}

}
