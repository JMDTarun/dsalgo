package dsalgo.leetcode.medium;

import dsalgo.common.ListNode;
import dsalgo.easy.grokking.common.LinkedList;

public class RemoveDuplicateFromSortedistII {

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode sentinel = new ListNode(0, head);

		ListNode pred = sentinel;

		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				pred.next = head.next;
			} else {
				pred = pred.next;
			}
			head = head.next;
		}
		return sentinel.next;
	}

	public static void main(String[] args) {
		ListNode linkedList = new ListNode(1);
		linkedList.next = new ListNode(2);
		linkedList.next.next = new ListNode(3);
		linkedList.next.next.next = new ListNode(3);
		linkedList.next.next.next.next = new ListNode(4);
		linkedList.next.next.next.next.next = new ListNode(4);
		linkedList.next.next.next.next.next.next = new ListNode(5);
		deleteDuplicates(linkedList);
		System.out.println(linkedList);
	}

}
