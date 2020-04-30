package dsalgo.easy.grokking.subsets.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {

	// Given a set of numbers that might contain duplicates, find all of its
	// distinct subsets.
	//
	// Example 1:
	//
	// Input: [1, 3, 3]
	// Output: [], [1], [3], [1,3], [3,3], [1,3,3]
	// Example 2:
	//
	// Input: [1, 5, 3, 3]
	// Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3],
	// [3,3,5], [1,5,3,3]

	public static List<List<Integer>> findSubsets(int[] arr) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		subsets.add(set);
		Arrays.sort(arr);
		int lastProcessedValue = -1;
		List<List<Integer>> lastList = null;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == lastProcessedValue) {
				for (int k = 0; k < lastList.size(); k++) {
					set = new ArrayList<>(lastList.get(k));
					set.add(arr[i]);
					subsets.add(set);
				}
			} else {
				lastList = new ArrayList<>();
				int size = subsets.size();
				lastProcessedValue = arr[i];
				for (int j = 0; j < size; j++) {
					set = new ArrayList<>(subsets.get(j));
					set.add(arr[i]);
					subsets.add(set);
					lastList.add(set);
				}
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 3 };
		System.out.println(findSubsets(arr));
	}

}
