package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class HouseThief {

	public static int maxLoot(int hval[], int n) {
		if (n > hval.length - 1) {
			return 0;
		}
		int maxLoot = Integer.MIN_VALUE;
		for (int i = n; i < hval.length; i++) {
			maxLoot = Math.max(maxLoot, hval[i] + maxLoot(hval, i + 2));
		}
		return maxLoot;
	}

	public static int maxLootTopDown(int[] cache, int[] hval, int n) {
		if (n > hval.length - 1) {
			return 0;
		}
		if (cache[n] > 0) {
			return cache[n];
		}
		int maxLoot = Integer.MIN_VALUE;
		for (int i = n; i < hval.length; i++) {
			maxLoot = Math.max(maxLoot, hval[i] + maxLoot(hval, i + 2));
		}
		cache[n] = maxLoot;
		return cache[n];
	}

	public static int maxLootBottomUp(int hval[]) {
		int[] cache = new int[hval.length + 1];
		for (int i = 1; i <= hval.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				if (i - j > 1) {
					max = Math.max(max, cache[j] + hval[i - 1]);
					cache[i] = Math.max(max, cache[i - 1]);
				} else {
					cache[i] = Math.max(cache[i], hval[i - 1]);
				}
			}
		}
		return cache[hval.length];
	}
	
	public static void main(String[] args) {
		System.out.println(maxLoot(new int[] { 6, 7, 1, 3, 8, 2, 4 }, 0));
		System.out.println(maxLootTopDown(new int[8], new int[] { 6, 7, 1, 3, 8, 2, 4 }, 0));
		System.out.println(maxLootBottomUp(new int[] { 6, 7, 1, 3, 8, 2, 4 }));
	}

}
