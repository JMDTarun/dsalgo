package dsalgo.easy.grokking.kwaymerge.medium;

import java.util.PriorityQueue;

import dsalgo.easy.grokking.common.LinkedList;

public class KthSmallestNumberInMSortedLists {

	public static int findKthSmallest(LinkedList[] lists, int k) {
		PriorityQueue<LinkedList> minHeap = new PriorityQueue<>((l1, l2) -> l1.value - l2.value);

		for (int i = 0; i < lists.length; i++) {
			minHeap.add(lists[i]);
		}
		int counter = 0;
		int result = -1;
		while (!minHeap.isEmpty()) {
			LinkedList element = minHeap.poll();
			counter++;
			if (counter == k) {
				result = element.value;
				break;
			}
			if (element.next != null) {
				minHeap.add(element.next);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(2);
		list1.next = new LinkedList(6);
		list1.next.next = new LinkedList(8);

		LinkedList list2 = new LinkedList(3);
		list2.next = new LinkedList(6);
		list2.next.next = new LinkedList(7);

		LinkedList list3 = new LinkedList(1);
		list3.next = new LinkedList(3);
		list3.next.next = new LinkedList(4);

		System.out.println(findKthSmallest(new LinkedList[] { list1, list2, list3 }, 2));

	}

}
