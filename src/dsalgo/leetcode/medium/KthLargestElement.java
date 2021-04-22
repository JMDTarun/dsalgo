package dsalgo.leetcode.medium;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static int findKthLargest(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
		int i = 0;
		for (; i < k; i++) {
			minHeap.add(nums[i]);
		}

		for (; i < nums.length; i++) {
			Integer peek = minHeap.peek();
			if (nums[i] > peek) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] arr = { 3,2,3,1,2,4,5,5,6 };
		System.out.println(findKthLargest(arr, 4));
	}

}
