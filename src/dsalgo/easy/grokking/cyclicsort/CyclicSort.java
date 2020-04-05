package dsalgo.easy.grokking.cyclicsort;

public class CyclicSort {

	// We are given an array containing ‘n’ objects. Each object, when created, was
	// assigned a unique number from 1 to ‘n’ based on their creation sequence. This
	// means that the object with sequence number ‘3’ was created just before the
	// object with sequence number ‘4’.
	//
	// Write a function to sort the objects in-place on their creation sequence
	// number in O(n)O(n) and without any extra space. For simplicity, let’s assume
	// we are passed an integer array containing only the sequence numbers, though
	// each number is actually an object.
	//
	// Input: [3, 1, 5, 4, 2]
	// Output: [1, 2, 3, 4, 5]
	//
	// Input: [2, 6, 4, 3, 1, 5]
	// Output: [1, 2, 3, 4, 5, 6]
	//
	// Input: [1, 5, 6, 4, 3, 2]
	// Output: [1, 2, 3, 4, 5, 6]

	private static void sort(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == i + 1) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[arr[i] - 1];
				arr[temp - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 4, 3, 2 };
		sort(arr);
		for(int i: arr) {
			System.out.println(i);
		}
	}

}
