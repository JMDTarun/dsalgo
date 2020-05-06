package dsalgo.easy.grokking.twoheaps.medium;

import java.util.PriorityQueue;

public class FindTheMedianOfANumberStream {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

	public void insertNumber(int num) {
		if (maxHeap.isEmpty() || num < maxHeap.peek()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (double)(maxHeap.peek() + minHeap.peek()) / 2;
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		FindTheMedianOfANumberStream findTheMedianOfANumberStream = new FindTheMedianOfANumberStream();
		findTheMedianOfANumberStream.insertNumber(3);
		findTheMedianOfANumberStream.insertNumber(1);
		System.out.println(findTheMedianOfANumberStream.findMedian());
		findTheMedianOfANumberStream.insertNumber(5);
		System.out.println(findTheMedianOfANumberStream.findMedian());
		findTheMedianOfANumberStream.insertNumber(4);
		System.out.println(findTheMedianOfANumberStream.findMedian());

	}

}
