package dsalgo.easy.grokking.topkelements.easy;

import java.util.PriorityQueue;

public class KthSmallestNumber {

	// Given an unsorted array of numbers, find Kth smallest number in it.
	//
	// Please note that it is the Kth smallest number in the sorted order, not the
	// Kth distinct element.
	//
	// Note: For a detailed discussion about different approaches to solve this
	// problem, take a look at Kth Smallest Number.
	//
	// Example 1:
	//
	// Input: [1, 5, 12, 2, 11, 5], K = 3
	// Output: 5
	// Explanation: The 3rd smallest number is '5', as the first two smaller numbers
	// are [1, 2].
	// Example 2:
	//
	// Input: [1, 5, 12, 2, 11, 5], K = 4
	// Output: 5
	// Explanation: The 4th smallest number is '5', as the first three small numbers
	// are [1, 2, 5].
	// Example 3:
	//
	// Input: [5, 12, 11, -1, 12], K = 3
	// Output: 11
	// Explanation: The 3rd smallest number is '11', as the first two small numbers
	// are [5, -1].

	public static int findKthSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
		int i = 0;
		for (; i < k; i++) {
			maxHeap.add(nums[i]);
		}
		for (; i < nums.length; i++) {
			if (nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 5, 12, 11, -1, 12 };
		System.out.println(findKthSmallestNumber(nums, 3));
	}

}
