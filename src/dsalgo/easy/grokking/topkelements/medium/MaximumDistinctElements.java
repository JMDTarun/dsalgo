package dsalgo.easy.grokking.topkelements.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumDistinctElements {

	public static int findMaximumElements(int[] arr, int r) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer i : arr) {
			map.compute(i, (k, v) -> v != null ? v + 1 : 1);
		}
		PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(e1, e2) -> e1.getValue() - e2.getValue());

		int count = 0;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> e : entrySet) {
			if (e.getValue() > 1) {
				minHeap.add(e);
			} else {
				count++;
			}
		}

		int c = 0;
		while (!minHeap.isEmpty() && c < r) {
			Entry<Integer, Integer> peek = minHeap.peek();
			int value = peek.getValue() - 1;
			if (value == 1) {
				count++;
				minHeap.poll();
			} else {
				peek.setValue(value);
			}
			c++;
		}
		if (c < r) {
			count = count - (r - c);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findMaximumElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2));
		System.out.println(findMaximumElements(new int[] { 3, 5, 12, 11, 12 }, 3));
		System.out.println(findMaximumElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2));
	}

}
