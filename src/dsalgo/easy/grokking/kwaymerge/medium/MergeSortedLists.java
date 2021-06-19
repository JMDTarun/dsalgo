package dsalgo.easy.grokking.kwaymerge.medium;

import java.util.PriorityQueue;

import dsalgo.common.ListNode;

public class MergeSortedLists {

	public static ListNode merge(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}

		ListNode list = null;
		ListNode nextPointer = null;
		while (!minHeap.isEmpty()) {
			ListNode min = minHeap.poll();
			if (list == null) {
				list = new ListNode(min.val);
				nextPointer = list;
			} else {
				nextPointer.next = new ListNode(min.val);
				nextPointer = nextPointer.next;
			}
			if (min.next != null) {
				minHeap.add(min.next);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(6);
		list1.next.next = new ListNode(8);

		ListNode list2 = new ListNode(3);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(7);

		ListNode list3 = new ListNode(1);
		list3.next = new ListNode(3);
		list3.next.next = new ListNode(4);

		ListNode result = merge(new ListNode[] { list1, list2, list3 });
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
