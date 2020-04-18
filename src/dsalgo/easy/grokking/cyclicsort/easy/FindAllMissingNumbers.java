package dsalgo.easy.grokking.cyclicsort.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

	// We are given an unsorted array containing numbers taken from the range 1 to
	// ‘n’. The array can have duplicates, which means some numbers will be missing.
	// Find all those missing numbers.

	// Input: [2, 3, 1, 8, 2, 3, 5, 1]
	// Output: 4, 6, 7
	// Explanation: The array should have all numbers from 1 to 8, due to duplicates
	// 4, 6, and 7 are missing.
	//
	// Input: [2, 4, 1, 2]
	// Output: 3
	//
	// Input: [2, 3, 2, 1]
	// Output: 4

	public static List<Integer> findMissingNumbers(int[] arr) {
		List<Integer> missingNumbers = new ArrayList<>();
		int i = 0;
		while (i < arr.length) {
			int currentNum = arr[i];
			int replacedNum = arr[currentNum - 1];
			if (arr[i] == i + 1 || currentNum == replacedNum) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[temp - 1];
				arr[temp - 1] = temp;
			}
		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != j + 1) {
				missingNumbers.add(j + 1);
			}
		}
		return missingNumbers;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 8, 2, 3, 5, 1 };
		System.out.println(findMissingNumbers(arr));
	}

}
