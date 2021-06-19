package dsalgo.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

	Map<Integer, Integer> values = new HashMap<Integer, Integer>();
	Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
	Map<Integer, LinkedHashSet<Integer>> scoreObject = new HashMap<>();

	int capacity = 0;
	int minValue = 1;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		scoreObject.put(1, new LinkedHashSet<Integer>());
	}

	public int get(int key) {
		if (!values.containsKey(key)) {
			return -1;
		}
		Integer integer = counts.get(key);
		int incrementedValue = integer + 1;
		counts.put(key, incrementedValue);
		scoreObject.get(integer).remove(key);
		if (!scoreObject.containsKey(incrementedValue)) {
			scoreObject.put(incrementedValue, new LinkedHashSet<>());
		}
		scoreObject.get(incrementedValue).add(key);
		return values.get(key);
	}

	public void put(int key, int value) {
		if (capacity <= 0) {
			return;
		}

		if (values.containsKey(key)) {
			values.put(key, value);
			get(key);
			return;
		}

		if (values.size() == capacity) {
			Integer next = scoreObject.get(minValue).iterator().next();
			scoreObject.get(key).remove(next);
			values.remove(next);
		}
		values.put(key, value);
		minValue = 1;
		counts.put(key, 1);
		scoreObject.get(1).add(key);
	}

}
