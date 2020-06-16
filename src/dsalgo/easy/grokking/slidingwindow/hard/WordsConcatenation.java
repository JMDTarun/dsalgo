package dsalgo.easy.grokking.slidingwindow.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {

	// Words Concatenation (hard) #
	// Given a string and a list of words, find all the starting indices of
	// substrings in the given string that are a concatenation of all the given
	// words exactly once without any overlapping of words. It is given that all
	// words are of the same length.
	//
	// Example 1:
	//
	// Input: String="catfoxcat", Words=["cat", "fox"]
	// Output: [0, 3]
	// Explanation: The two substring containing both the words are "catfox" &
	// "foxcat".
	// Example 2:
	//
	// Input: String="catcatfoxfox", Words=["cat", "fox"]
	// Output: [3]
	// Explanation: The only substring containing both the words is "catfox".

	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.compute(word, (k, v) -> v != null ? v + 1 : 1);
		}
		int wordSize = words[0].length();
		int startWindow = 0;
		int endWindow = wordSize;
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		while (endWindow <= str.length() + 1) {
			if (map.containsKey(str.substring(endWindow - wordSize, endWindow))) {
				tempMap.compute(str.substring(endWindow - wordSize, endWindow), (k, v) -> v != null ? v + 1 : 1);
				if (tempMap.size() == map.size()) {
					while (true) {
						tempMap.compute(str.substring(startWindow, startWindow + wordSize), (k, v) -> v - 1);
						if (tempMap.get(str.substring(startWindow, startWindow + wordSize)) > 0) {
							startWindow = startWindow + wordSize;
						} else {
							result.add(startWindow);
							tempMap.remove(str.substring(startWindow, startWindow + wordSize));
							startWindow = startWindow + wordSize;
							break;
						}
					}
				}
			} else {
				startWindow = endWindow + 1;
			}
			endWindow += wordSize;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findWordConcatenation("catfoxcat", new String[] { "cat", "fox" }));
		System.out.println(findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" }));
	}

}
