package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		if (numCourses == 1) {
			return new int[1];
		}

		int arr[] = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();

		for (int i = 0; i < numCourses; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int[] a = prerequisites[i];
			if (a.length > 0) {
				if (graph.containsKey(a[0])) {
					graph.get(a[0]).add(a[1]);
				} else {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(a[1]);
					graph.put(a[0], temp);
				}
				inDegree.compute(a[1], (k, v) -> v == null ? 1 : v + 1);
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (inDegree.get(i) == 0) {
				queue.add(i);
			}
		}

		int counter = numCourses - 1;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			arr[counter] = poll;
			counter--;
			List<Integer> list = graph.get(poll);
			if (list != null && list.size() > 0) {
				for (Integer i : list) {
					inDegree.compute(i, (k, v) -> v - 1);
					if (inDegree.get(i) == 0) {
						queue.add(i);
					}
				}
			}
		}
		if ((counter + 1) == 0) {
			return arr;
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[][] arr = { {} };
		System.out.println(findOrder(2, arr));
	}

}
