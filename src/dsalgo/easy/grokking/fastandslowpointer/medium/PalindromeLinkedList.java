package dsalgo.easy.grokking.fastandslowpointer.medium;

import dsalgo.easy.grokking.common.LinkedList;

public class PalindromeLinkedList {

	// Palindrome LinkedList (medium) #
	// Given the head of a Singly LinkedList, write a method to check if the
	// LinkedList is a palindrome or not.
	//
	// Your algorithm should use constant space and the input LinkedList should be
	// in the original form once the algorithm is finished. The algorithm should
	// have O(N)O(N) time complexity where ‘N’ is the number of nodes in the
	// LinkedList.
	//
	// Example 1:
	//
	// Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
	// Output: true
	// Example 2:
	//
	// Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
	// Output: false

	public static boolean isPalindrome(LinkedList linkedList) {
		boolean isPalindrome = true;
		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		LinkedList previous = null;
		LinkedList next = null;
		LinkedList current = linkedList;

		while (current != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		while (slowPointer != null) {
			if (slowPointer.value != previous.value) {
				isPalindrome = false;
				break;
			}
			slowPointer = slowPointer.next;
			previous = previous.next;
		}
		return isPalindrome;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(2);
		linkedList.next = new LinkedList(4);
		linkedList.next.next = new LinkedList(6);
		linkedList.next.next.next = new LinkedList(6);
		linkedList.next.next.next.next = new LinkedList(4);
		linkedList.next.next.next.next.next = new LinkedList(2);
		System.out.println(isPalindrome(linkedList));
	}

}
