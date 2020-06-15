package dsalgo.easy.grokking.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {

	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<Integer>();
		if (vertices < 0) {
			return sortedOrder;
		}
		Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Entry<Integer, Integer>> entrySet = inDegree.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			sortedOrder.add(vertex);
			List<Integer> children = graph.get(vertex);
			for (Integer child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0) {
					queue.add(child);
				}
			}
		}

		if (sortedOrder.size() != vertices) {
			return new ArrayList<Integer>();
		}

		return sortedOrder;
	}

	public static void main(String[] args) {
		
	}

}
