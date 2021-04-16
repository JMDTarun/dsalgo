package dsalgo.leetcode.medium;

import dsalgo.common.ListNode;

public class PartitionList {
	public static ListNode partition(ListNode head, int x) {

		ListNode firstHalf = new ListNode();
		ListNode secondHalf = new ListNode();

		ListNode tempFirstHalf = firstHalf;
		ListNode tempSecondHalf = secondHalf;
		
		ListNode node = head;

		while (node != null) {
			if (node.val < x) {
				tempFirstHalf.next = new ListNode(node.val);
				tempFirstHalf = tempFirstHalf.next;
			} else {
				tempSecondHalf.next = new ListNode(node.val);
				tempSecondHalf = tempSecondHalf.next;
			}
			node = node.next;
		}
		tempFirstHalf.next = secondHalf.next;
		ListNode result = firstHalf.next;
		
		return result;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(4);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(2);
		partition(node, 3);
	}
}
