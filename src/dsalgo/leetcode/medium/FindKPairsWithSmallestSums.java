package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();

		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return new ArrayList<List<Integer>>();
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));

		for (int i = 0; i < nums1.length; i++) {
			minHeap.add(new int[] { nums1[i], nums2[0], 0 });
		}

		while (!minHeap.isEmpty() && k > 0) {
			int[] poll = minHeap.poll();
			int index = poll[2];
			tempList = new ArrayList<Integer>();
			tempList.add(poll[0]);
			tempList.add(poll[1]);
			result.add(tempList);
			k--;
			if (index + 1 < nums2.length) {
				minHeap.add(new int[] { poll[0], nums2[index + 1], index + 1 });
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		kSmallestPairs(nums1, nums2, 3);
	}

}
