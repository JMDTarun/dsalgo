package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public static int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				count = Math.max(count, map.get(sum));
			}
		}

		return wall.size() - count;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(2);
		l.add(1);
		list.add(l);

		l = new ArrayList<Integer>();
		l.add(3);
		l.add(1);
		l.add(2);
		list.add(l);

		l = new ArrayList<Integer>();
		l.add(1);
		l.add(3);
		l.add(2);
		list.add(l);

		l = new ArrayList<Integer>();
		l.add(2);
		l.add(4);
		list.add(l);

		l = new ArrayList<Integer>();
		l.add(3);
		l.add(1);
		l.add(2);
		list.add(l);

		l = new ArrayList<Integer>();
		l.add(1);
		l.add(3);
		l.add(3);
		l.add(1);
		list.add(l);

		leastBricks(list);
	}

}
