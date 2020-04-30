package dsalgo.easy.grokking.subsets.easy;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	// Given a set with distinct elements, find all of its distinct subsets.
	//
	// Example 1:
	//
	// Input: [1, 3]
	// Output: [], [1], [3], [1,3]
	// Example 2:
	//
	// Input: [1, 5, 3]
	// Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

	public static List<List<Integer>> findSubsets(int[] arr) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		subsets.add(set);
		for (int i = 0; i < arr.length; i++) {
			int size = subsets.size();
			for (int j = 0; j < size; j++) {
				set = new ArrayList<>(subsets.get(j));
				set.add(arr[i]);
				subsets.add(set);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3 };
		System.out.println(findSubsets(arr));
	}

}
