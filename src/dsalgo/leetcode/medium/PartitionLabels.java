package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

	public static List<Integer> partitionLabels(String s) {
		List<Integer> result = new ArrayList<Integer>();

		if (s == null) {
			return result;
		}

		if (s.length() == 1) {
			result.add(1);
			return result;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		int start = 0;
		Integer startWindow = 0;
		Integer endWindow = null;
		while (start < s.length()) {
			if (endWindow == null) {
				endWindow = map.get(s.charAt(start));
			}
			Integer window = map.get(s.charAt(start));
			if (window < endWindow) {
				start++;
				continue;
			} else if (window > endWindow) {
				endWindow = map.get(s.charAt(start));
			} else if (start == endWindow) {
				result.add(endWindow - startWindow + 1);
				startWindow = endWindow + 1;
				endWindow = null;
			}
			start++;
		}

		return result;
	}

	public static void main(String[] args) {
		partitionLabels("ababcbacadefegdehijhklij");
	}

}
