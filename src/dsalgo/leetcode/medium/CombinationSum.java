package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		combinationSum(candidates, target, set, new ArrayList<Integer>());
		return new ArrayList<List<Integer>>(set);
	}

	public static void combinationSum(int[] candidates, int target, Set<List<Integer>> set, List<Integer> list) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			List<Integer> toAdd = new ArrayList<Integer>(list);
			toAdd.sort((i1, i2) -> i1 - i2);
			set.add(toAdd);
		}
		for (int i = 0; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], set, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5 };
		combinationSum(arr, 8);
	}

}
