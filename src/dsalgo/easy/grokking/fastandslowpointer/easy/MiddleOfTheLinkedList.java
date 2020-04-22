package dsalgo.easy.grokking.fastandslowpointer.easy;

import dsalgo.easy.grokking.common.LinkedList;

public class MiddleOfTheLinkedList {

	// Given the head of a Singly LinkedList, write a method to return the middle
	// node of the LinkedList.
	//
	// If the total number of nodes in the LinkedList is even, return the second
	// middle node.
	//
	// Example 1:
	//
	// Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
	// Output: 3
	// Example 2:
	//
	// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
	// Output: 4
	// Example 3:
	//
	// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
	// Output: 4

	public static LinkedList findMiddle(LinkedList linkedList) {
		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(2);
		linkedList.next.next = new LinkedList(3);
		linkedList.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next = new LinkedList(5);
		linkedList.next.next.next.next.next = new LinkedList(6);
		linkedList.next.next.next.next.next.next = new LinkedList(7);
		System.out.println(findMiddle(linkedList).value);
	}

}
