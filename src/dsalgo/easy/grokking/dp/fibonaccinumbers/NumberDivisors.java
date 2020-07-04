package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class NumberDivisors {

	public static int numberDivisors(int number, int value, int divisors) {
		if (number == 0) {
			return divisors;
		}
		if (value % number == 0) {
			divisors++;
		}

		return numberDivisors(number - 1, value, divisors);
	}

	public static int numberDivisorsTopDown(int number) {
		int matrix[] = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			matrix[i] = number % i == 0 ? 1 : 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(numberDivisors(24, 24, 0));
	}

}
