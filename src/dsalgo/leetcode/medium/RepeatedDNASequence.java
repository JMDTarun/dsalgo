package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (seen.contains(ten)) {
				repeated.add(ten);
			}
			seen.add(ten);
		}
		return new ArrayList<>(repeated);
	}

	public static void main(String[] args) {
		findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}

}
