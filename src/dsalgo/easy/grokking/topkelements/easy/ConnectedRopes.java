package dsalgo.easy.grokking.topkelements.easy;

import java.util.PriorityQueue;

//Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.

//
//Example 1:
//
//Input: [1, 3, 11, 5]
//Output: 33
//Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
//Example 2:
//
//Input: [3, 4, 5, 6]
//Output: 36
//Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
//Example 3:
//
//Input: [1, 3, 11, 5, 2]
//Output: 42
//Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)

public class ConnectedRopes {

	public static int minimumCostToConnectRopes(int[] ropes) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
		for (int i = 0; i < ropes.length; i++) {
			minHeap.add(ropes[i]);
		}
		int tempCost = 0;
		int totalCost = 0;
		while (minHeap.size() > 1) {
			tempCost = minHeap.poll() + minHeap.poll();
			totalCost += tempCost;
			minHeap.add(tempCost);
		}
		return totalCost;
	}

	public static void main(String[] args) {
		System.out.println(minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 }));
		System.out.println(minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 }));
		System.out.println(minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 }));
	}

}
