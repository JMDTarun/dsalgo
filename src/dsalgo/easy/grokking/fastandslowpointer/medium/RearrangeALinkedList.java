package dsalgo.easy.grokking.fastandslowpointer.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class RearrangeALinkedList {

//	Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
//
//			Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
//
//			Example 1:
//
//			Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
//			Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null 
//			Example 2:
//
//			Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
//			Output: 2 -> 10 -> 4 -> 8 -> 6 -> null

	public static void reorder(LinkedList linkedList) {
		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		LinkedList start = linkedList;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		// reverse linked list
		LinkedList previous = null;
		LinkedList current = slowPointer.next;
		LinkedList next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		slowPointer.next = previous;

		while (previous != null) {
			LinkedList temp = start.next;
			LinkedList previousNext = previous.next;
			slowPointer.next = previousNext;
			start.next = previous;
			previous.next = temp;
			start = temp;
			previous = previousNext;
		}

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(2);
		linkedList.next.next = new LinkedList(3);
		linkedList.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next = new LinkedList(5);
		linkedList.next.next.next.next.next = new LinkedList(6);
		reorder(linkedList);
		System.out.println(linkedList);

		linkedList = new LinkedList(2);
		linkedList.next = new LinkedList(4);
		linkedList.next.next = new LinkedList(6);
		linkedList.next.next.next = new LinkedList(8);
		linkedList.next.next.next.next = new LinkedList(10);
		reorder(linkedList);
		System.out.println(linkedList);
	}

}
