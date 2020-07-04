package dsalgo.easy.grokking.topkelements.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SchedulingTasks {

	// You are given a list of tasks that need to be run, in any order, on a server.
	// Each task will take one CPU interval to execute but once a task has finished,
	// it has a cooling period during which it can’t be run again. If the cooling
	// period for all tasks is ‘K’ intervals, find the minimum number of CPU
	// intervals that the server needs to finish all tasks.
	//
	// If at any time the server can’t execute any task then it must stay idle.
	//
	// Example 1:
	//
	// Input: [a, a, a, b, c, c], K=2
	// Output: 7
	// Explanation: a -> c -> b -> a -> c -> idle -> a
	// Example 2:
	//
	// Input: [a, b, a], K=3
	// Output: 5
	// Explanation: a -> b -> idle -> idle -> a

	public static int scheduleTasks(char[] tasks, int coolingPeriod) {
		int cost = 0;
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (Character i : tasks) {
			frequencyMap.compute(i, (k, v) -> v != null ? v + 1 : 1);
		}
		PriorityQueue<Entry<Character, Integer>> maxHeap = new PriorityQueue<Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(frequencyMap.entrySet());
		boolean stopAtEnd = false;
		StringBuilder strBuilder = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			List<Entry<Character, Integer>> list = new ArrayList<>();
			stopAtEnd = maxHeap.peek().getValue() < 2;
			for (int i = 0; i <= coolingPeriod; i++) {
				Entry<Character, Integer> poll = maxHeap.poll();
				if (stopAtEnd && poll == null) {
					break;
				}
				if (poll != null && poll.getValue() > 0) {
					strBuilder.append(poll.getKey());
					poll.setValue(poll.getValue() - 1);
					if (poll.getValue() > 0) {
						list.add(poll);
					}
				} else {
					strBuilder.append("_");
				}
				cost++;
			}
			maxHeap.addAll(list);
		}
		System.out.println(strBuilder.toString());
		return cost;
	}

	public static void main(String[] args) {
		System.out.println(scheduleTasks(new char[] { 'a', 'a', 'a', 'a', 'b', 'c', 'c' }, 2));
		System.out.println(scheduleTasks(new char[] { 'a', 'b', 'a' }, 3));
		System.out.println(scheduleTasks(new char[] { 'a', 'a', 'a' }, 2));
	}

}
