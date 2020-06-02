package dsalgo.easy.grokking.topkelements.medium;

import java.util.PriorityQueue;

public class KthLargestNumberInAStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

	public KthLargestNumberInAStream(int arr[], int k) {

		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (counter < k) {
				minHeap.add(arr[i]);
				counter++;
			} else {
				add(arr[i]);
			}
		}
	}

	public int add(int num) {
		if (minHeap.peek() < num) {
			minHeap.poll();
			minHeap.add(num);
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		KthLargestNumberInAStream kthLargestNumberInAStream = new KthLargestNumberInAStream(
				new int[] { 3, 1, 5, 12, 2, 11 }, 4);
		System.out.println(kthLargestNumberInAStream.add(6));
		System.out.println(kthLargestNumberInAStream.add(13));
		System.out.println(kthLargestNumberInAStream.add(4));
	}

}
