package dsalgo.leetcode.medium;

public class FibonacciNumber {

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int[] cache = new int[n + 1];
		cache[1] = 1;

		int start = 2;
		while (start <= n) {
			cache[start] = cache[start - 1] + cache[start - 2];
			start++;
		}

		return cache[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(4));
	}

}
