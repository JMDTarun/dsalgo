package dsalgo.easy.grokking.topologicalsort.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class TasksScheduling {

	// There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
	// prerequisite tasks which need to be completed before it can be scheduled.
	// Given the number of tasks and a list of prerequisite pairs, find out if it is
	// possible to schedule all the tasks.
	//
	// Example 1:
	//
	// Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
	// Output: true
	// Explanation: To execute task '1', task '0' needs to finish first. Similarly,
	// task '1' needs to finish
	// before '2' can be scheduled. A possible sceduling of tasks is: [0, 1, 2]
	// Example 2:
	//
	// Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
	// Output: false
	// Explanation: The tasks have cyclic dependency, therefore they cannot be
	// sceduled.
	// Example 3:
	//
	// Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
	// Output: true
	// Explanation: A possible sceduling of tasks is: [0 1 4 3 2 5]

	public static boolean isSchedulingPossible(int tasks, int[][] prerequisities) {
		Map<Integer, Integer> inDegreeMap = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < tasks; i++) {
			inDegreeMap.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisities.length; i++) {
			int parent = prerequisities[i][0];
			int child = prerequisities[i][1];
			inDegreeMap.put(child, inDegreeMap.get(child) + 1);
			graph.get(parent).add(child);
		}

		Queue<Integer> queue = new LinkedList<>();

		for (Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			List<Integer> children = graph.get(poll);
			count++;
			for (Integer child : children) {
				inDegreeMap.put(child, inDegreeMap.get(child) - 1);
				if (inDegreeMap.get(child) == 0) {
					queue.add(child);
				}
			}
		}
		if (count != tasks) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isSchedulingPossible(3, new int[][] { { 0, 1 }, { 1, 2 } }));
		System.out.println(isSchedulingPossible(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }));
		System.out.println(
				isSchedulingPossible(6, new int[][] { { 2, 5 }, { 0, 5 }, { 0, 4 }, { 1, 4 }, { 3, 2 }, { 1, 3 } }));
	}

}
