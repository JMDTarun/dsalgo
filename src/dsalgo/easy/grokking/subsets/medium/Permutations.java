package dsalgo.easy.grokking.subsets.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> findPermutations(int[] num) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		set.add(num[0]);
		subsets.add(set);
		for (int i = 1; i < num.length; i++) {
			int size = subsets.size();
			List<List<Integer>> tempSubsets = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				int setSize = subsets.get(j).size();
				for (int k = 0; k <= setSize; k++) {
					set = new ArrayList<>(subsets.get(j));
					set.add(k, num[i]);
					tempSubsets.add(set);
				}
			}
			subsets = tempSubsets;
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4 };
		System.out.println(findPermutations(arr));
	}

}
