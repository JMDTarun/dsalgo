package dsalgo.easy.grokking.twoheaps.hard;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		int startWindowPointer = 0;
		int endWindowPointer = 0;
		while (endWindowPointer < nums.length) {
			if (maxHeap.isEmpty() || nums[endWindowPointer] < maxHeap.peek()) {
				maxHeap.add(nums[endWindowPointer]);
			} else {
				minHeap.add(nums[endWindowPointer]);
			}
			rebalanceHeap();
			if ((endWindowPointer - startWindowPointer) + 1 == k) {
				if (maxHeap.size() == minHeap.size()) {
					double d = (double) (maxHeap.peek() + minHeap.peek()) / 2;
					result[startWindowPointer] = d;
				} else {
					result[startWindowPointer] = maxHeap.peek();
				}
				if (nums[startWindowPointer] < minHeap.peek()) {
					maxHeap.remove(nums[startWindowPointer]);
				} else {
					minHeap.remove(nums[startWindowPointer]);
				}
				startWindowPointer++;
				rebalanceHeap();
			}
			endWindowPointer++;
		}
		return result;
	}

	public void rebalanceHeap() {
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		int[] nums = { 1, 2, -1, 3, 5 };
		double[] results = slidingWindowMedian.findSlidingWindowMedian(nums, 3);
		for (double r : results) {
			System.out.println(r);
		}
	}

}
