package dsalgo.leetcode.hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC_239_SlidingWindowMaximum {

	// Given an array nums, there is a sliding window of size k which is moving from
	// the very left of the array to the very right. You can only see the k numbers
	// in the window. Each time the sliding window moves right by one position.
	// Return the max sliding window.

	// Follow up:
	// Could you solve it in linear time?
	//
	// Example:
	//
	// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	// Output: [3,3,5,5,6,7]
	// Explanation:
	//
	// Window position Max
	// --------------- -----
	// [1 3 -1] -3 5 3 6 7 3
	// 1 [3 -1 -3] 5 3 6 7 3
	// 1 3 [-1 -3 5] 3 6 7 5
	// 1 3 -1 [-3 5 3] 6 7 5
	// 1 3 -1 -3 [5 3 6] 7 6
	// 1 3 -1 -3 5 [3 6 7] 7

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int result[] = new int[(nums.length - k) + 1];

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int j = k - 1; j >= 0; j--) {
			if (deque.isEmpty()) {
				deque.add(nums[j]);
			} else {
				if (nums[j] > deque.getLast()) {
					deque.offerLast(nums[j]);
				} else {
					deque.offerFirst(nums[j]);
				}
			}
		}
		int i = k;
		int startIndex = 0;
		result[startIndex] = deque.getLast();
		while (i < nums.length) {
			deque.removeFirstOccurrence(new Integer(nums[startIndex]));
			if (!deque.isEmpty() && nums[i] > deque.getLast()) {
				deque.clear();
				deque.offerLast(nums[i]);
			} else {
				deque.addFirst(nums[i]);
			}

			startIndex++;
			i++;
			result[startIndex] = deque.getLast();
		}
		return result;
	}

	public static int[] maxSlidingWindow1(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			// q contains index... r contains content
			deque.offer(i);
			if (i >= k - 1) {
				r[ri++] = nums[deque.peek()];
			}
		}
		return r;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, -1, -3, -5, 3, 6, 7 };
		int[] result = maxSlidingWindow1(arr, 3);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

}
