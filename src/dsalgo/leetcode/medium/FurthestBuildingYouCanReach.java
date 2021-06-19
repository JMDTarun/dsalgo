package dsalgo.leetcode.medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < heights.length - 1; i++) {
			int d = heights[i + 1] - heights[i];
			if (d > 0) {
				pq.add(d);
			}
			if (pq.size() > ladders) {
				bricks -= pq.poll();
			}
			if (bricks < 0) {
				return i;
			}
		}
		return heights.length - 1;
	}

	public static void main(String[] args) {
		int[] A = { 4, 2, 7, 6, 9, 14, 12 };
		furthestBuilding(A, 5, 1);
	}

}
