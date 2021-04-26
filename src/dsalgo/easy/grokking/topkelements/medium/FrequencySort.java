package dsalgo.easy.grokking.topkelements.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class FrequencySort {

//	Given a string, sort it based on the decreasing frequency of its characters.
//
//	Example 1:
//
//	Input: "Programming"
//	Output: "rrggmmPiano"
//	Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
//	Example 2:
//
//	Input: "abcbab"
//	Output: "bbbaac"
//	Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.

	public static String frequencySort(String s) {

		if (s == null || s.length() == 0) {
			return "";
		}
		
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		char[] charArray = s.toCharArray();
		for (Character c : charArray) {
			frequencyMap.compute(c, (k, v) -> v != null ? v + 1 : 1);
		}

		PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(frequencyMap.entrySet());

		StringBuilder strBuilder = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Entry<Character, Integer> element = maxHeap.poll();
			for (int i = 0; i < element.getValue(); i++) {
				strBuilder.append(element.getKey());
			}
		}
		return strBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("Programming"));
		System.out.println(frequencySort("abcbab"));
	}

}
