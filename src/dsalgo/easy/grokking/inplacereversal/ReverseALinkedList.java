package dsalgo.easy.grokking.inplacereversal;

import dsalgo.easy.grokking.common.LinkedList;

public class ReverseALinkedList {

	// Given the head of a Singly LinkedList, reverse the LinkedList. Write a
	// function to return the new head of the reversed LinkedList.

	private static LinkedList reverseLinkedList(LinkedList head) {

		LinkedList previous = null;
		LinkedList current = head;
		LinkedList next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(2);
		linkedList.next = new LinkedList(4);
		linkedList.next.next = new LinkedList(6);
		linkedList.next.next.next = new LinkedList(8);
		linkedList.next.next.next.next = new LinkedList(10);
		// linkedList.next.next.next.next = new LinkedList(6);
		reverseLinkedList(linkedList);
	}

}
