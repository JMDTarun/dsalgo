package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class FibonacciNumbers {

	public static int fibonacciNumbers(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2);
	}

	public static int fibonacciNumbersTopDown(int n) {
		int[] matrix = new int[n + 1];
		matrix[1] = 1;

		for (int i = 2; i <= n; i++) {
			matrix[i] = matrix[i - 1] + matrix[i - 2];
		}

		return matrix[n];
	}

	public static void main(String[] args) {
		System.out.println(fibonacciNumbers(9));
		System.out.println(fibonacciNumbersTopDown(9));
	}

}
