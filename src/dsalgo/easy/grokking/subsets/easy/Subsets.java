package dsalgo.easy.grokking.subsets.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		subsets.add(list);
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < nums.length; i++) {
			int size = subsets.size();
			for (int j = 0; j < size; j++) {
				list = new ArrayList<>(subsets.get(j));
				list.add(nums[i]);
				list.sort((a, b) -> a - b);
				if (!set.contains(list.toString())) {
					subsets.add(list);
				}
				set.add(list.toString());
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 4, 4, 1, 4 };
		System.out.println(findSubsets(arr));
	}

}
