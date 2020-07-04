package dsalgo.easy.grokking.topologicalsort.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class AllTasksSchedulingOrders {

	public static void printOrder(int tasks, int[][] prerequisities) {

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

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		List<Integer> order = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			order.add(poll);
			List<Integer> list = graph.get(poll);
			Map<Integer, Integer> tempInDegree = new HashMap<Integer, Integer>();
			tempInDegree.putAll(inDegreeMap);
			Queue<Integer> tempQueue = new LinkedList<Integer>();
			tempQueue.addAll(queue);
			List<Integer> tempList = new ArrayList<Integer>();
 			for (Integer l : list) {
				inDegreeMap.compute(l, (k, v) -> v - 1);
				if (inDegreeMap.get(l) == 0) {
					tempList.add(l);
				}
			}
 			if (tempList.size() > 1) {
 				
 			} else {
 				queue.addAll(tempList);
 			}
		}

		if (order.size() == tasks) {
			System.out.println(order);
		} else {
			System.out.println("Cycle in execution.");
		}

	}

	public static void main(String[] args) {
		printOrder(3, new int[][] { { 0, 1 }, { 1, 2 } });
		printOrder(4, new int[][] { { 3, 2 }, { 3, 0 }, { 2, 0 }, { 2, 1 } });
		// printOrder(6, new int[][] { { 2, 5 }, { 0, 5 }, { 0, 4 }, { 1, 4 }, { 3, 2 },
		// { 1, 3 } });
	}

}
