package dsalgo.easy.grokking.topkelements.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {

	// Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
	//
	// Note: For a detailed discussion about different approaches to solve this
	// problem, take a look at Kth Smallest Number.
	//
	// Example 1:
	//
	// Input: [3, 1, 5, 12, 2, 11], K = 3
	// Output: [5, 12, 11]
	// Example 2:
	//
	// Input: [5, 12, 11, -1, 12], K = 3
	// Output: [12, 11, 12]

	public static List<Integer> findKLargestNumbers(int nums[], int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
		int i = 0;
		for (i = 0; i < k; i++) {
			minHeap.add(nums[i]);
		}
		for (; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		int[] nums = { 5, 12, 11, -1, 12 };
		System.out.println(findKLargestNumbers(nums, 3));
	}

}
