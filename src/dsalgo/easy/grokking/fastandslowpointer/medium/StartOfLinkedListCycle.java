package dsalgo.easy.grokking.fastandslowpointer.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class StartOfLinkedListCycle {

	public static LinkedList findCycleStart(LinkedList linkedList) {

		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		boolean isLoopExists = false;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (slowPointer == fastPointer) {
				isLoopExists = true;
				System.out.println(cycleLength(slowPointer));
				break;
			}
		}

		if (isLoopExists) {
			slowPointer = linkedList;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			return slowPointer;
		}

		return null;
	}

	private static int cycleLength(LinkedList linkedList) {
		int cycleLength = 0;
		LinkedList current = linkedList;
		do {
			current = current.next;
			cycleLength++;
		} while (current != linkedList);
		return cycleLength;
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(101);
		linkedList.next = new LinkedList(201);
		linkedList.next.next = new LinkedList(301);
		linkedList.next.next.next = new LinkedList(401);
		linkedList.next.next.next.next = new LinkedList(501);
		linkedList.next.next.next.next.next = linkedList.next.next.next;
		findCycleStart(linkedList);
	}

}
