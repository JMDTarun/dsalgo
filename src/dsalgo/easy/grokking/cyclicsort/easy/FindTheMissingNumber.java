package dsalgo.easy.grokking.cyclicsort.easy;

public class FindTheMissingNumber {

	// We are given an array containing ‘n’ distinct numbers taken from the range 0
	// to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
	// find the missing number.

	// Input: [4, 0, 3, 1]
	// Output: 2
	//
	// Input: [8, 3, 5, 2, 4, 6, 0, 1]
	// Output: 7

	public static int findMissingNumber(int[] arr) {
		int missingNumber = -1;
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == 0 || arr[i] == i + 1) {
				if (arr[i] == 0) {
					missingNumber = i + 1;
				}
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
			}
		}
		return missingNumber;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 3, 5, 2, 4, 6, 0, 1 };
		System.out.println(findMissingNumber(arr));
	}

}
