package dsalgo.leetcode.hard;

public class BestTimeToBuyAndSellStockIII {

	public static int maxProfit(int[] prices) {
		int firstBuy = Integer.MIN_VALUE;
		int secondBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondSell = 0;

		for (int price : prices) {
			firstBuy = Math.max(firstBuy, -price);
			firstSell = Math.max(firstSell, price + firstBuy);
			secondBuy = Math.max(secondBuy, firstSell - price);
			secondSell = Math.max(secondSell, secondBuy + price);
		}
		return secondSell;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(arr));
	}

}
