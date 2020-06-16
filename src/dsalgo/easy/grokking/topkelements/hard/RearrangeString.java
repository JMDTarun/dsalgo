package dsalgo.easy.grokking.topkelements.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeString {

	// Problem Statement #
	// Given a string, find if its letters can be rearranged in such a way that no
	// two same characters come next to each other.
	//
	// Example 1:
	//
	// Input: "aappp"
	// Output: "papap"
	// Explanation: In "papap", none of the repeating characters come next to each
	// other.
	// Example 2:
	//
	// Input: "Programming"
	// Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
	// Explanation: None of the repeating characters come next to each other.
	// Example 3:
	//
	// Input: "aapa"
	// Output: ""
	// Explanation: In all arrangements of "aapa", atleast two 'a' will come
	// together e.g., "apaa", "paaa".

	public static String rearrangeString(String str) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (Character i : str.toCharArray()) {
			frequencyMap.compute(i, (k, v) -> v != null ? v + 1 : 1);
		}

		PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(frequencyMap.entrySet());

		Entry<Character, Integer> previous = null;
		String result = "";
		while (!maxHeap.isEmpty()) {
			Entry<Character, Integer> poll = maxHeap.poll();
			if (previous != null && previous.getValue() > 0) {
				maxHeap.add(previous);
			}
			result = result.concat(Character.toString(poll.getKey()));
			poll.setValue(poll.getValue() - 1);
			previous = poll;
		}
		return result.length() == str.length() ? result : "";
	}

	public static void main(String[] args) {
		System.out.println(rearrangeString("aappp"));
		System.out.println(rearrangeString("Programming"));
		System.out.println(rearrangeString("aapa"));
		System.out.println(rearrangeString("aapar"));
	}

}
