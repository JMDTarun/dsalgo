package dsalgo.practice;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(getPalindromeNumber(2002));
	}

	private static int getPalindromeNumber(int num) {
		if (num == 0) {
			return 0;
		}
		int numTemp = num % 10;
		num = num / 10;
		int sum = getPalindromeNumber(num);
		sum = 10 * sum + numTemp;
		return sum;
	}

}
