package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int s = triangle.size();
		for (int i = s - 2; i >= 0; i--) {
			List<Integer> current = triangle.get(i);
			List<Integer> next = triangle.get(i + 1);
			for (int j = 0; j < current.size(); j++) {
				int min = Math.min(next.get(j), next.get(j + 1));
				current.set(j, current.get(j) + min);
			}
		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		list.add(nums);
		nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(4);
		list.add(nums);
		nums = new ArrayList<Integer>();
		nums.add(6);
		nums.add(5);
		nums.add(7);
		list.add(nums);
		nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(1);
		nums.add(8);
		nums.add(3);
		list.add(nums);
		minimumTotal(list);
	}

}
