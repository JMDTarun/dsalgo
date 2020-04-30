package dsalgo.easy.grokking.subsets.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> findPermutations(int[] num) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		set.add(num[0]);
		subsets.add(set);
		int startIndex, endIndex;
		for (int i = 1; i < num.length; i++) {
			int size = subsets.size();
			set = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				if (subsets.get(j).size() > 1) {
					set = new ArrayList<>(subsets.get(j));
					startIndex = 1;
					endIndex = set.size() - 1;
					while (startIndex <= endIndex) {
						set.add(startIndex, num[i]);
						subsets.add(set);
						startIndex++;
					}
					if (set.size() == num.length) {
						results.add(set);
					}
				}
				set = new ArrayList<>(subsets.get(j));
				set.add(0, num[i]);
				subsets.add(set);
				if (set.size() == num.length) {
					results.add(set);
				}
				set = new ArrayList<>(subsets.get(j));
				set.add(num[i]);
				subsets.add(set);
				if (set.size() == num.length) {
					results.add(set);
				}
			}
		}
		System.out.println(results.size());
		return results;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4 };
		System.out.println(findPermutations(arr));
	}

}
