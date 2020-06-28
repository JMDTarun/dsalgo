package dsalgo.easy.grokking.topologicalsort.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class TasksSchedulingOrder {

	// There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
	// prerequisite tasks which need to be completed before it can be scheduled.
	// Given the number of tasks and a list of prerequisite pairs, write a method to
	// find the ordering of tasks we should pick to finish all tasks.
	//
	// Example 1:
	//
	// Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
	// Output: [0, 1, 2]
	// Explanation: To execute task '1', task '0' needs to finish first. Similarly,
	// task '1' needs to finish
	// before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]
	// Example 2:
	//
	// Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
	// Output: []
	// Explanation: The tasks have cyclic dependency, therefore they cannot be
	// scheduled.
	// Example 3:
	//
	// Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
	// Output: [0 1 4 3 2 5]
	// Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]

	public static List<Integer> findOrder(int tasks, int[][] prerequistes) {
		List<Integer> order = new ArrayList<Integer>();
		Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < tasks; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequistes.length; i++) {
			int parent = prerequistes[i][0];
			int child = prerequistes[i][1];
			inDegree.put(child, inDegree.get(child) + 1);
			graph.get(parent).add(child);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			if (poll < tasks) {
				order.add(poll);
			}
			List<Integer> children = graph.get(poll);
			for (Integer child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0) {
					queue.add(child);
				}
			}
		}
		if (order.size() != tasks) {
			return new ArrayList<Integer>();
		}
		return order;
	}

	public static void main(String[] args) {
		System.out.println(findOrder(3, new int[][] { { 0, 1 }, { 1, 2 } }));
		System.out.println(findOrder(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
		System.out.println(findOrder(6, new int[][] { { 2, 5 }, { 0, 5 }, { 0, 4 }, { 1, 4 }, { 3, 2 }, { 1, 3 } }));
	}

}
