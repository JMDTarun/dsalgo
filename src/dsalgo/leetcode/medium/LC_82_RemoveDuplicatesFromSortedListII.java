package dsalgo.leetcode.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class LC_82_RemoveDuplicatesFromSortedListII {

	
	public static LinkedList deleteDuplicates1(LinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedList temp = new LinkedList(0);
		LinkedList cur = head.next;
		LinkedList pre = head;
		LinkedList lastPointer = temp;

		while (cur.next != null) {
			if (cur.value == cur.next.value) {
				cur = cur.next;
				continue;
			} else {
				if (cur.value == cur.next.value) {
					continue;
				} else {
					pre.next = cur;
					pre = cur;
					temp.next = cur;
				}
			}
			cur = cur.next;
		}
		if (pre != null && cur != null && pre.value == cur.value) {
			lastPointer.next = null;
		}
		return null;
	}
	
	public static LinkedList deleteDuplicates(LinkedList head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedList cur = head.next;
		LinkedList pre = head;

		while (cur.next != null) {
			if (cur.value == pre.value) {
				cur = cur.next;
			} else {
				pre.next = cur;
				pre = cur;
			}
			cur = cur.next;
		}
		if (pre != null && cur != null && pre.value == cur.value) {
			pre.next = null;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(1);
		linkedList.next.next = new LinkedList(1);
		linkedList.next.next.next = new LinkedList(2);
		linkedList.next.next.next.next = new LinkedList(3);
		linkedList.next.next.next.next.next = new LinkedList(3);
		deleteDuplicates1(linkedList);
	}

}
