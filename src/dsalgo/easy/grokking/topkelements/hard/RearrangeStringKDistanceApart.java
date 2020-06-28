package dsalgo.easy.grokking.topkelements.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

public class RearrangeStringKDistanceApart {

	// Given a string and a number ‘K’, find if the string can be rearranged such
	// that the same characters are at least ‘K’ distance apart from each other.
	//
	// Example 1:

	// Input: "mmpp", K=2
	// Output: "mpmp" or "pmpm"
	// Explanation: All same characters are 2 distance apart.
	// Example 2:
	//
	// Input: "Programming", K=3
	// Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
	// Explanation: All same characters are 3 distance apart.
	// Example 3:
	//
	// Input: "aab", K=2
	// Output: "aba"
	// Explanation: All same characters are 2 distance apart.
	// Example 4:
	//
	// Input: "aappa", K=3
	// Output: ""
	// Explanation: We cannot find an arrangement of the string where any two 'a'
	// are 3 distance apart.

	public static String reorganizeString(String str, int k) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (Character i : str.toCharArray()) {
			frequencyMap.compute(i, (key, value) -> value != null ? value + 1 : 1);
		}

		PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(frequencyMap.entrySet());

		String result = "";
		int counter = 1;
		Queue<Entry<Character, Integer>> queue = new LinkedList<Map.Entry<Character, Integer>>();
		while (!maxHeap.isEmpty()) {
			Entry<Character, Integer> poll = maxHeap.poll();
			result = result.concat(Character.toString(poll.getKey()));
			poll.setValue(poll.getValue() - 1);
			if (counter < k) {
				counter++;
				queue.add(poll);
			} else {
				Entry<Character, Integer> poll2 = queue.poll();
				if (poll2 != null && poll2.getValue() > 0) {
					maxHeap.add(poll2);
				}
				if (poll.getValue() > 0) {
					queue.add(poll);
				}
			}
		}
		return result.length() == str.length() ? result : "";
	}

	public static void main(String[] args) {
//		System.out.println(reorganizeString("mmpp", 2));
		System.out.println(reorganizeString("Programming", 3));
//		System.out.println(reorganizeString("aappa", 3));
//		System.out.println(reorganizeString("aab", 2));
	}

}
