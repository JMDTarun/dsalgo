package dsalgo.easy.grokking.kwaymerge.hard;

import java.util.PriorityQueue;

import dsalgo.common.Node;

public class KthSmallestNumberInASortedMatrix {

//	Given an N * N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.
//
//	Example 1:
//
//	Input: Matrix=[
//	    [2, 6, 8], 
//	    [3, 7, 10],
//	    [5, 8, 11]
//	  ], 
//	  K=5
//	Output: 7
//	Explanation: The 5th smallest number in the matrix is 7.

	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> matrix[n1.arrayIndex][n1.elementIndex] - matrix[n2.arrayIndex][n2.elementIndex]);
		for (int i = 0; i < matrix.length; i++) {
			Node node = new Node(0, i, matrix[i][0]);
			minHeap.add(node);
		}

		int counter = 0;
		int kthSmallest = -1;
		while (!minHeap.isEmpty()) {
			Node element = minHeap.poll();
			counter++;
			if (counter == k) {
				kthSmallest = matrix[element.arrayIndex][element.elementIndex];
				break;
			}
			if (element.elementIndex < matrix[element.arrayIndex].length - 1) {
				minHeap.add(new Node(element.elementIndex + 1, element.arrayIndex,
						matrix[element.arrayIndex][element.elementIndex + 1]));
			}
		}
		return kthSmallest;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
		System.out.println(findKthSmallest(matrix, 5));
	}

}
