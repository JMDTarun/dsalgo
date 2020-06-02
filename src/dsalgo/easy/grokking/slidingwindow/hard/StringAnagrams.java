package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

//	String Anagrams (hard) #
//	Given a string and a pattern, find all anagrams of the pattern in the given string.
//
//	Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
//
//	abc
//	acb
//	bac
//	bca
//	cab
//	cba
//	Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
//
//	Example 1:
//
//	Input: String="ppqp", Pattern="pq"
//	Output: [1, 2]
//	Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
//	Example 2:
//
//	Input: String="abbcabc", Pattern="abc"
//	Output: [2, 3, 4]
//	Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> resultIndicies = new ArrayList<Integer>();

		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

		for (int i = 0; i < pattern.length(); i++) {
			characterMap.compute(pattern.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		int windowStart = 0;
		int windowEnd = 0;
		Map<Character, Integer> tempMap = new HashMap<>();

		while (windowEnd < str.length()) {
			if (characterMap.containsKey(str.charAt(windowEnd))) {
				tempMap.compute(str.charAt(windowEnd), (k, v) -> v == null ? 1 : v + 1);
				if (tempMap.size() == characterMap.size() && (windowEnd - windowStart) + 1 == pattern.length()) {
					resultIndicies.add(windowStart);
				}
			} else {
				windowStart = windowEnd;
				tempMap.clear();
				windowStart++;
			}
			if ((windowEnd - windowStart) + 1 == pattern.length()) {
				tempMap.compute(str.charAt(windowStart), (k, v) -> v - 1);
				if (tempMap.get(str.charAt(windowStart)) == 0) {
					tempMap.remove(str.charAt(windowStart));
				}
				windowStart++;
			}
			windowEnd++;
		}
		return resultIndicies;
	}

	public static void main(String[] args) {
		System.out.println(findStringAnagrams("ppqp", "pq"));
		System.out.println(findStringAnagrams("abbcabc", "abc"));
	}

}
