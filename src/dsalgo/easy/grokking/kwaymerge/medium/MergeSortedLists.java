package dsalgo.easy.grokking.kwaymerge.medium;

import java.util.PriorityQueue;

import dsalgo.easy.grokking.common.LinkedList;

public class MergeSortedLists {

	public static LinkedList merge(LinkedList[] lists) {
		PriorityQueue<LinkedList> minHeap = new PriorityQueue<>((l1, l2) -> l1.value - l2.value);

		for (int i = 0; i < lists.length; i++) {
			minHeap.add(lists[i]);
		}

		LinkedList list = null;
		LinkedList nextPointer = null;
		while (!minHeap.isEmpty()) {
			LinkedList min = minHeap.poll();
			if (list == null) {
				list = new LinkedList(min.value);
				nextPointer = list;
			} else {
				nextPointer.next = new LinkedList(min.value);
				nextPointer = nextPointer.next;
			}
			if (min.next != null) {
				minHeap.add(min.next);
			}
		}

		return list;
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

		LinkedList result = merge(new LinkedList[] { list1, list2, list3 });
		while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}

}
