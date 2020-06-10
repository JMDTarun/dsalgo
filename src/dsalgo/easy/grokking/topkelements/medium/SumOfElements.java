package dsalgo.easy.grokking.topkelements.medium;

import java.util.PriorityQueue;

public class SumOfElements {

	public static int findSumOfElements(int[] arr, int start, int end) {
		int sum = 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		for (Integer i : arr) {
			minHeap.add(i);
		}

		int counter = 0;

		while (!minHeap.isEmpty()) {
			counter++;
			Integer val = minHeap.poll();
			if (counter > start && counter < end) {
				sum += val;
			}
			if (counter > end) {
				break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6));
		System.out.println(findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4));
	}

}
