package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class MinCostClimbingStairs {

	// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
	// indexed).
	//
	// Once you pay the cost, you can either climb one or two steps. You need to
	// find minimum cost to reach the top of the floor, and you can either start
	// from the step with index 0, or the step with index 1.
	//
	// Example 1:
	// Input: cost = [10, 15, 20]
	// Output: 15
	// Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
	// Example 2:
	// Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
	// Output: 6
	// Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
	// cost[3].

	public static int minCostClimbingStairs(int[] costs, int index) {
		if (index > costs.length - 1) {
			return 0;
		}
		costs[index] += Math.min(costs[index - 1], costs[index - 2]);
		minCostClimbingStairs(costs, index + 1);
		return Math.min(costs[costs.length - 1], costs[costs.length - 2]);
	}

	public static int minCostClimbingStairs(int[] costs) {
		for (int i = 2; i < costs.length; i++) {
			costs[i] += Math.min(costs[i - 1], costs[i - 2]);
		}
		return Math.min(costs[costs.length - 1], costs[costs.length - 2]);
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }, 2));
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20, 20, 10 }, 2));
	}

}
