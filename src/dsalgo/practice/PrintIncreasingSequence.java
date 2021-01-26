package dsalgo.practice;

public class PrintIncreasingSequence {

	public static void main(String[] args) {
		printNumbers(0, 0, 2, 3);
	}

	private static void printNumbers(int s, int start, int size, int max) {
		if (start > max) {
			return;
		}
		if (String.valueOf(s).length() == size) {
			System.out.println(s);
			return;
		}

		for (int i = start; i < max; i++) {
			if (i + 1 > (s % 10)) {
				int num = s * 10 + (i + 1);
				printNumbers(num, i + 1, size, max);
			}
		}
	}

}
