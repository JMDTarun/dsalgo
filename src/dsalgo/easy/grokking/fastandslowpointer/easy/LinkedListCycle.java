package dsalgo.easy.grokking.fastandslowpointer.easy;

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

	private static void deleteNode(LinkedList list, LinkedList delete) {
		LinkedList next = delete.next;
		delete.value = next.value;
		delete.next = delete.next.next;
		System.out.println(list.value);
	}
 	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(2);
		linkedList.next.next = new LinkedList(3);
		linkedList.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next = new LinkedList(5);
		System.out.println(isLoopExist(linkedList));
		deleteNode(linkedList, linkedList.next);
	}

}
