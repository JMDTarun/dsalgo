package dsalgo.easy.grokking.kwaymerge.hard;

import java.util.PriorityQueue;

import dsalgo.common.Node;

public class SmallestNumberRange {

	public static int[] findSmallestRange(int[][] matrix, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> matrix[n1.arrayIndex][n1.elementIndex] - matrix[n2.arrayIndex][n2.elementIndex]);
		int maxSoFar = Integer.MIN_VALUE;
		int i = 0;
		int count = 0;
		for (; i < matrix.length; i++) {
			count += matrix[i].length;
			Node node = new Node(0, i, matrix[i][0]);
			maxSoFar = Math.max(maxSoFar, matrix[i][0]);
			minHeap.add(node);
		}
		int minDifference = maxSoFar - minHeap.peek().value;
		int startRange = minHeap.peek().value;
		int endRange = maxSoFar;
		int kthSmallest = -1;
		while (i < count) {
			Node element = minHeap.poll();
			i++;
			if (element.elementIndex < matrix[element.arrayIndex].length - 1) {
				Node node = new Node(element.elementIndex + 1, element.arrayIndex,
						matrix[element.arrayIndex][element.elementIndex + 1]);
				minHeap.add(node);
				maxSoFar = Math.max(maxSoFar, node.value);
				if (maxSoFar - minHeap.peek().value < minDifference) {
					minDifference = maxSoFar - minHeap.peek().value;
					startRange = minHeap.peek().value;
					endRange = maxSoFar;
				}
			}
		}
		return new int[] { startRange, endRange };
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 8 }, { 4, 12 }, { 7, 8, 10 } };
		int[] findSmallestRange = findSmallestRange(matrix, 5);
		System.out.println(findSmallestRange[0] + ", " + findSmallestRange[1]);

		int[][] matrix1 = { { 1, 9 }, { 4, 12 }, { 7, 10, 16 } };
		findSmallestRange = findSmallestRange(matrix1, 5);
		System.out.println(findSmallestRange[0] + ", " + findSmallestRange[1]);
	}

}
