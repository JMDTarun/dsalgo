package dsalgo.easy.grokking.kwaymerge.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithLargestSums {

	// K Pairs with Largest Sums (Hard) #
	// Given two sorted arrays in descending order, find ‘K’ pairs with the largest
	// sum where each pair consists of numbers from both the arrays.
	//
	// Example 1:
	//
	// Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
	// Output: [9, 3], [9, 6], [8, 6]
	// Explanation: These 3 pairs have the largest sum. No other pair has a sum
	// larger than any of these.
	// Example 2:
	//
	// Input: L1=[5, 2, 1], L2=[2, -1], K=3
	// Output: [5, 2], [5, -1], [2, 2]

	public static List<int[]> findKLargestPairs(int[] arr1, int[] arr2, int k) {
		List<int[]> result = new ArrayList<>();
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1, p2) -> (p1[0] + p1[1]) - (p2[0] + p2[1]));
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (count < k) {
					count++;
					minHeap.add(new int[] { arr1[i], arr2[j] });
				} else {
					if (arr1[i] + arr2[j] > minHeap.peek()[0] + minHeap.peek()[1]) {
						minHeap.poll();
						minHeap.add(new int[] { arr1[i], arr2[j] });
					}
				}
			}
		}
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		List<int[]> findKLargestPairs = findKLargestPairs(new int[] { 9, 8, 2 }, new int[] { 6, 3, 1 }, 3);
		for (int[] arr : findKLargestPairs) {
			System.out.println(arr[0] + ", " + arr[1]);
		}
	}

}
