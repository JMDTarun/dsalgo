package dsalgo.easy.algoexpert.medium;

import dsalgo.common.ListNode;

public class RemoveNthNodeFromEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return null;
		}
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode firstPointer = temp;
		ListNode secondPointer = temp;

		for (int i = 0; i <= n; i++) {
			firstPointer = firstPointer.next;
		}

		while (firstPointer != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		secondPointer.next = secondPointer.next.next;
		return temp.next;
	}

	public static ListNode removeNthFromEnd1(ListNode head, int n) {

		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode firstPointer = head;
		ListNode secondPointer = head;

		for (int i = 0; i <= n; i++) {
			firstPointer = firstPointer.next;
		}

		while (firstPointer != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		secondPointer = secondPointer.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode linkedList = new ListNode(1);
		linkedList.next = new ListNode(2);
//		linkedList.next.next = new ListNode(3);
//		linkedList.next.next.next = new ListNode(4);
//		linkedList.next.next.next.next = new ListNode(5);
		removeNthFromEnd(linkedList, 2);
	}

}
