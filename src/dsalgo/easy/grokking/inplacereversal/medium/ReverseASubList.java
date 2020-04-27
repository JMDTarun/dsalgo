package dsalgo.easy.grokking.inplacereversal.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class ReverseASubList {

	// Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the
	// LinkedList from position ‘p’ to ‘q’.

	public static LinkedList reverse(LinkedList list, int start, int end) {
		int counter = 0;
		LinkedList previous = null;
		LinkedList next = null;
		LinkedList current = list;
		LinkedList previousListEnd = null;
		LinkedList subListEnd = null;
		for (int i = 0; current != null && i < start - 1; ++i) {
			previousListEnd = current;
			current = current.next;
			counter++;
		}

		while (current != null) {
			counter++;
			if (counter == start) {
				subListEnd = current;
			}
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

			if (counter == end) {
				break;
			}
		}
		subListEnd.next = current;
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
		LinkedList reverse = reverse(linkedList, 2, 3);
		while (reverse != null) {
			System.out.println(reverse.value);
			reverse = reverse.next;
		}
	}

}
