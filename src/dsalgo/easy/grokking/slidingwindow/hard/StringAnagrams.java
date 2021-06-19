package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public static List<Integer> findStringAnagrams(String s, String p) {
		List<Integer> resultIndicies = new ArrayList<Integer>();

		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

		for (int i = 0; i < p.length(); i++) {
			characterMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		int windowStart = 0;
		int windowEnd = 0;
		Map<Character, Integer> tempMap = new HashMap<>();
		int counter = 0;
		while (windowEnd < s.length()) {
			if (characterMap.containsKey(s.charAt(windowEnd))) {
				char charAt = s.charAt(windowEnd);
				tempMap.compute(charAt, (k, v) -> v == null ? 1 : v + 1);
				boolean isIncrementCounter = false;
				if (tempMap.get(charAt) != characterMap.get(charAt)) {
					isIncrementCounter = false;
				} else {
					isIncrementCounter = true;
				}

				if (tempMap.get(charAt).intValue() == characterMap.get(charAt).intValue()) {
					counter--;
				} else if (isIncrementCounter) {
					counter++;
				}
				if (counter == 0 && tempMap.get(charAt).intValue() == characterMap.get(charAt).intValue()
						&& tempMap.size() == characterMap.size() && (windowEnd - windowStart) + 1 == p.length()) {
					resultIndicies.add(windowStart);
				}
			} else {
				windowStart = windowEnd;
				tempMap.clear();
				windowStart++;
				counter = 0;
			}
			if ((windowEnd - windowStart) + 1 == p.length()) {
				char charAt = s.charAt(windowStart);
				boolean isIncrementCounter = false;
				if (tempMap.get(charAt) != characterMap.get(charAt)) {
					isIncrementCounter = false;
				} else {
					isIncrementCounter = true;
				}
				tempMap.compute(charAt, (k, v) -> v - 1);
				if (isIncrementCounter) {
					counter++;
				}
				if (tempMap.get(s.charAt(windowStart)) == 0) {
					tempMap.remove(s.charAt(windowStart));
				}
				windowStart++;
			}
			windowEnd++;
		}
		return resultIndicies;
	}
	
	public static List<Integer> findPermutation1(String str, String pattern) {
		int start = 0;
		int end = 0;
		int counter = 0;
		List<Integer> anagrams = new ArrayList<Integer>();
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			frequencyMap.compute(pattern.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		while (end < str.length()) {
			char endChar = str.charAt(end);

			if (frequencyMap.containsKey(endChar)) {
				frequencyMap.compute(endChar, (k, v) -> v - 1);
				if (frequencyMap.get(endChar) == 0) {
					counter++;
				}
			}
			if (counter == frequencyMap.size()) {
				anagrams.add(start);
			}
			if (end - start + 1 >= pattern.length()) {
				char startChar = str.charAt(start++);
				if (frequencyMap.containsKey(startChar)) {
					if (frequencyMap.get(startChar) == 0) {
						counter--;
					}
					frequencyMap.compute(startChar, (k, v) -> v + 1);
				}
			}
			end++;
		}
		return anagrams;
	}


	public static void main(String[] args) {
		System.out.println(findPermutation1("abbcabc", "abc"));
//		System.out.println(findStringAnagrams("abbcabc", "abc"));

	}

}
