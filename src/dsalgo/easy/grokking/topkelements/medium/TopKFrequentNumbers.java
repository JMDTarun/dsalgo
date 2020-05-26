package dsalgo.easy.grokking.topkelements.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

//	Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
//
//	Example 1:
//
//	Input: [1, 3, 5, 12, 11, 12, 11], K = 2
//	Output: [12, 11]
//	Explanation: Both '11' and '12' apeared twice.
//	Example 2:
//
//	Input: [5, 12, 11, 3, 11], K = 2
//	Output: [11, 5] or [11, 12] or [11, 3]
//	Explanation: Only '11' appeared twice, all other numbers appeared once.

	public static List<Integer> findTopKFrequentNumbers(int[] nums, int x) {
		List<Integer> topNumbers = new ArrayList<Integer>();
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		for (Integer i : nums) {
			frequencyMap.compute(i, (k, v) -> v != null ? v + 1 : 1);
		}

		PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<Entry<Integer, Integer>>(
				(e1, e2) -> e1.getValue() - e2.getValue());
		int counter = 0;
		for (Entry<Integer, Integer> e : frequencyMap.entrySet()) {
			if (counter == x) {
				if (minHeap.peek().getValue() < e.getValue()) {
					minHeap.poll();
					minHeap.add(e);
				}
			} else {
				minHeap.add(e);
				counter++;
			}
		}

		while (!minHeap.isEmpty()) {
			Entry<Integer, Integer> element = minHeap.poll();
			topNumbers.add(element.getKey());
		}
		return topNumbers;
	}

	public static void main(String[] args) {
		System.out.println(findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2));
		System.out.println(findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2));
	}

}
