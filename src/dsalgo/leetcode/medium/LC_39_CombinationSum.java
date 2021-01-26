package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_39_CombinationSum {

	public static List<List<Integer>> combinationSum(Set<List<Integer>> set, int[] candidates, int target, int index, List<Integer> tempList,
			List<List<Integer>> finalList) {
		if (target < 0) {
			return finalList;
		}
		if (target == 0) {
			finalList.add(new ArrayList<Integer>(tempList));
			set.add(new ArrayList<Integer>(tempList));
			return finalList;
		}
		for (int i = index; i < candidates.length; i++) {
			tempList.add(candidates[i]);
			combinationSum(set, candidates, target - candidates[i], i + 1, tempList, finalList);
			tempList.remove(tempList.size() - 1);
		}
		return finalList;
	}

	public static void main(String[] args) {
		int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		Arrays.sort(candidates);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		int target = 8;
		List<Integer> tempList = new ArrayList<Integer>();
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		combinationSum(set, candidates, target, 0, tempList, finalList);
		System.out.println(set);
	}

}
