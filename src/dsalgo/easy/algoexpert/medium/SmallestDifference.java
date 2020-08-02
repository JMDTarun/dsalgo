package dsalgo.easy.algoexpert.medium;

import java.util.Arrays;

public class SmallestDifference {

	// Given two arrays of integers, compute the pair of values (one value in each
	// array) with the smallest (non-negative) difference. Return the difference.
	//
	// Examples :
	//
	// Input : A[] = {l, 3, 15, 11, 2}
	// B[] = {23, 127, 235, 19, 8}
	// Output : 3
	// That is, the pair (11, 8)
	//
	// Input : A[] = {l0, 5, 40}
	// B[] = {50, 90, 80}
	// Output : 10
	// That is, the pair (40, 50)

	public static int getSmallestDifference(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int arr1Pointer = 0;
		int arr2Pointer = 0;
		int diff = Integer.MAX_VALUE;
		while (arr1Pointer < arr1.length || arr2Pointer < arr2.length) {

			if (Math.abs(arr1[arr1Pointer] - arr2[arr2Pointer]) < diff) {
				diff = Math.abs(arr1[arr1Pointer] - arr2[arr2Pointer]);
			}
			if (arr1[arr1Pointer] < arr2[arr2Pointer] && arr1Pointer < arr1.length - 1) {
				arr1Pointer++;
			} else if (arr1[arr1Pointer] > arr2[arr2Pointer] && arr1Pointer < arr1.length - 1) {
				arr2Pointer++;
			} else {
				return diff;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		System.out
				.println(getSmallestDifference(new int[] { -1, 5, 10, 20, 28, 3 }, new int[] { 26, 134, 135, 15, 17 }));
	}

}
