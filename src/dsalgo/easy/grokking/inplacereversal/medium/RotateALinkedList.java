package dsalgo.easy.grokking.inplacereversal.medium;

import dsalgo.common.LinkedList;

public class RotateALinkedList {

	public static LinkedList rotate(LinkedList head, int k) {
		int listLength = 1;
		LinkedList current = head;
		while (current.next != null) {
			listLength++;
			current = current.next;
		}

		int numberOfNodesToRotate = k > listLength ? (k % listLength) - 1 : k;

		LinkedList next = null;
		LinkedList last = current;
		current = head;
		for (int i = 0; i < numberOfNodesToRotate; i++) {
			LinkedList temp = current;
			next = temp.next;
			last.next = current;
			current.next = null;
			last = temp;
			current = next;
			head = current;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(1);
		linkedList.next = new LinkedList(2);
		linkedList.next.next = new LinkedList(3);
		linkedList.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next = new LinkedList(5);
		// linkedList.next.next.next.next.next = new LinkedList(6);

		LinkedList reverse = rotate(linkedList, 8);
		while (reverse != null) {
			System.out.println(reverse.value);
			reverse = reverse.next;
		}

	}

}