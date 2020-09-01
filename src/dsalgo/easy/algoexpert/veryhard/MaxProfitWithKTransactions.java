package dsalgo.easy.algoexpert.veryhard;

public class MaxProfitWithKTransactions {

	public static int maxProfit(int k, int[] prices) {
		return getMaxProfit(prices, 0, k, true);
	}

	public static int getMaxProfit(int[] prices, int startDay, int maxTransaction, boolean hasStock) {
		if (maxTransaction == 0 || startDay == prices.length) {
			return 0;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 3, 2, 6, 5, 0, 3 };
		System.out.println(maxProfit(2, prices));
	}

}
