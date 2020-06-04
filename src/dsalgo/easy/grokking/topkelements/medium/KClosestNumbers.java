package dsalgo.easy.grokking.topkelements.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dsalgo.common.Entry;

public class KClosestNumbers {

	public static List<Entry> findClosestElements(int[] arr, int k, Integer x) {
		PriorityQueue<Entry> maxHeap = new PriorityQueue<Entry>((e1, e2) -> e2.diff - e1.diff);
		int i = 0;
		for (; i < k; i++) {
			maxHeap.add(new Entry(arr[i], Math.abs(x.intValue() - arr[i])));
		}
		while (i < arr.length) {
			int diff = Math.abs(x - arr[i]);
			if (maxHeap.peek().diff > diff) {
				maxHeap.poll();
				maxHeap.add(new Entry(arr[i], diff));
			}
			i++;
		}
		return new ArrayList<>(maxHeap);
	}

	public static List<Integer> findClosestElementsTwoPointer(int[] arr, int k, Integer x) {
		List<Integer> result = new ArrayList<Integer>();
		int startPointer = 0;
		int endPointer = arr.length - 1;

		while (endPointer - startPointer >= k) {
			int diffWithStart = Math.abs(x - arr[startPointer]);
			int diffWithEnd = Math.abs(x - arr[endPointer]);

			if (diffWithStart > diffWithEnd) {
				startPointer++;
			} else {
				endPointer--;
			}
		}
		for (; startPointer <= endPointer; startPointer++) {
			result.add(arr[startPointer]);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7));
		System.out.println(findClosestElementsTwoPointer(new int[] { 5, 6, 7, 8, 9 }, 3, 7));
		System.out.println(findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10));
		System.out.println(findClosestElementsTwoPointer(new int[] { 2, 4, 5, 6, 9 }, 3, 10));

	}

}
