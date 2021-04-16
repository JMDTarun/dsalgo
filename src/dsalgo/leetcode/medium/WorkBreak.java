package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] arr = new boolean[s.length() + 1];
		arr[0] = true;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] && wordDict.contains(s.substring(j, i))) {
					arr[i] = true;
					break;
				}
			}
		}
		return arr[s.length()];
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("cats", "dog", "and", "cat"));
		wordBreak("catsand", list);
	}

}
