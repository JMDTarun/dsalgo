package dsalgo.easy.grokking.subsets.medium;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsByChangingCase {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		String val = "";
		permutations.add(val);
		for (int i = 0; i < str.length(); i++) {
			List<String> tempList = new ArrayList<>();
			int size = permutations.size();
			char c = str.charAt(i);
			for (int j = 0; j < size; j++) {
				if (c >= 48 && c <= 57) {
					tempList.add(permutations.get(j) + str.charAt(i));
				} else {
					tempList.add(permutations.get(j) + str.charAt(i));
					tempList.add(permutations.get(j) + ((str.charAt(i) + "").toUpperCase()));
				}
			}
			permutations = tempList;
		}
		return permutations;
	}

	public static void main(String[] args) {
		System.out.println(findLetterCaseStringPermutations("ab7c"));
	}

}
