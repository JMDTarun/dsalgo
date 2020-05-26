package dsalgo.easy.grokking.inplacereversal.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class ReverseAlternatingKElementSubList {

	public static LinkedList reverse(LinkedList list, int size) {
		LinkedList previous = null;
		LinkedList current = list;
		LinkedList next = null;
		LinkedList previousListEnd = null;
		LinkedList subListEnd = null;
		int counter = 0;
		boolean isReverse = true;
		while (current != null) {
			counter++;

			if (isReverse) {
				if (counter == 1) {
					subListEnd = current;
				}
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
				if (counter == size) {
					counter = 0;
					isReverse = false;
					subListEnd.next = current;
					if (previousListEnd == null) {
						list = previous;
						previousListEnd = subListEnd;
					} else {
						previousListEnd.next = previous;
						previousListEnd = subListEnd;
					}
					previous = null;
				}
			} else {
				if (counter == size) {
					counter = 0;
					previousListEnd = current;
					isReverse = true;
				}
				current = current.next;
			}
		}
		if (previousListEnd == null) {
			return previous;
		}
		previousListEnd.next = previous;
		return list;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(2);
		linkedList.next.next = new LinkedList(3);
		linkedList.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next = new LinkedList(5);
		linkedList.next.next.next.next.next = new LinkedList(6);
		linkedList.next.next.next.next.next.next = new LinkedList(7);
		linkedList.next.next.next.next.next.next.next = new LinkedList(8);
		LinkedList reverse = reverse(linkedList, 2);
		while (reverse != null) {
			System.out.println(reverse.value);
			reverse = reverse.next;
		}
	}

}
