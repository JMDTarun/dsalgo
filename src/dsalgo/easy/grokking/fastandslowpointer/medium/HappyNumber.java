package dsalgo.easy.grokking.fastandslowpointer.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class HappyNumber {

	// Any number will be called a happy number if, after repeatedly replacing it
	// with a number equal to the sum of the square of all of its digits, leads us
	// to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
	// they will be stuck in a cycle of numbers which does not include ‘1’.

	// Input: 23
	// Output: true (23 is a happy number)
	// Explanations: Here are the steps to find out that 23 is a happy number:
	//
	// Input: 12
	// Output: false (12 is not a happy number)
	// Explanations: Here are the steps to find out that 12 is not a happy number:

	public static boolean find(int num) {
		int slowPointer = findSquareRoot(num);
		int fastPointer = -1;
		while (slowPointer != fastPointer) {
			if (fastPointer == -1) {
				fastPointer = slowPointer;
			}
			fastPointer = findSquareRoot(fastPointer);
			fastPointer = findSquareRoot(fastPointer);
			slowPointer = findSquareRoot(slowPointer);
		}
		if (slowPointer == 1) {
			return true;
		}
		return false;
	}

	private static int findSquareRoot(int num) {
		int sum = 0;
		while (num != 0) {
			int rem = num % 10;
			sum += rem * rem;
			num = num / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(find(12));
	}

}
