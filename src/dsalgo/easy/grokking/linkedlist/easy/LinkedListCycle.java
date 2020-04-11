package dsalgo.easy.grokking.linkedlist.easy;

import dsalgo.easy.grokking.common.LinkedList;

public class LinkedListCycle {

	private static boolean isLoopExist(LinkedList head) {
		LinkedList slowPointer = head;
		LinkedList fastPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(101);
		linkedList.next = new LinkedList(201);
		linkedList.next.next = new LinkedList(301);
		linkedList.next.next.next = new LinkedList(401);
		linkedList.next.next.next.next = new LinkedList(501);
		System.out.println(isLoopExist(linkedList));
	}

}
