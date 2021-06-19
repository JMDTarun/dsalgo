package dsalgo.easy.grokking.cyclicsort.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicateNumbers {

	// Problem Statement #
	// We are given an unsorted array containing ‘n’ numbers taken from the
	// range 1
	// to ‘n’. The array has some duplicates, find all the duplicate numbers
	// without
	// using any extra space.
	//
	// Example 1:
	//
	// Input: [3, 4, 4, 5, 5]
	// Output: [4, 5]
	// Example 2:
	//
	// Input: [5, 4, 7, 2, 3, 5, 3]
	// Output: [3, 5]

	public static List<Integer> duplicateNumbers(int[] nums) {
		Set<Integer> duplicateNumbers = new HashSet<>();
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1) {
				i++;
			} else {
				int temp = nums[i];
				if (temp == nums[temp - 1]) {
					duplicateNumbers.add(temp);
					i++;
				} else {
					nums[i] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}
		return new ArrayList<Integer>(duplicateNumbers);
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(duplicateNumbers(arr));
	}

}
