package dsalgo.easy.grokking.cyclicsort.easy;

public class FindTheCorruptPair {

	// We are given an unsorted array containing ‘n’ numbers taken from the range 1
	// to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due
	// to a data error, one of the numbers got duplicated which also resulted in one
	// number going missing. Find both these numbers.
	//
	// Example 1:
	//
	// Input: [3, 1, 2, 5, 2]
	// Output: [2, 4]
	// Explanation: '2' is duplicated and '4' is missing.
	// Example 2:
	//
	// Input: [3, 1, 2, 3, 6, 4]
	// Output: [3, 5]
	// Explanation: '3' is duplicated and '5' is missing.

	public static int[] findNumbers(int[] nums) {
		int[] numbers = new int[2];
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1) {
				i++;
			} else {
				int temp = nums[i];
				if (temp == nums[temp - 1]) {
					numbers[0] = temp;
					numbers[1] = i + 1;
					i++;
				} else {
					nums[i] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		int[] findNumbers = findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
		for (Integer i : findNumbers) {
			System.out.println(i);
		}
	}

}
