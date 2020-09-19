package dsalgo.easy.grokking.subsets.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import dsalgo.common.ParanthesisString;

public class BalancedParanthesis {

	public static Set<String> getBalancedParanthesis(int num) {
		String start = "";
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		Set<String> set = new HashSet<>();
		int i = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			String paranthesis = null;
			List<String> tempList = new ArrayList<>();
			for (int m = 0; m < size; m++) {
				paranthesis = queue.poll();
				int paranthesisSize = paranthesis.length();
				StringBuilder sb = null;
				int j = 0;
				do {
					sb = new StringBuilder(paranthesis);
					tempList.add(sb.insert(j, "{").toString());
					j++;
				} while (j < paranthesisSize);

				int k = 0;
				do {
					paranthesis = tempList.get(k);
					sb = new StringBuilder(paranthesis);
					sb.insert(k + 1, "}").toString();
					tempList.set(k, sb.toString());
					k++;
				} while (k < tempList.size());
				queue.addAll(tempList);
				tempList.clear();
			}
			i++;
			if (i == num) {
				set.addAll(queue);
				break;
			}
		}
		return set;
	}

	public static List<String> getBalancedParanthesisOptimized(int num) {
		List<String> result = new ArrayList<String>();

		Queue<ParanthesisString> queue = new LinkedList<>();
		queue.add(new ParanthesisString(0, 0, ""));

		while (!queue.isEmpty()) {
			ParanthesisString ps = queue.poll();
			if (ps.openCount == num && ps.closeCount == num) {
				result.add(ps.str);
			}
			if (ps.openCount < num) {
				queue.add(new ParanthesisString(ps.openCount + 1, ps.closeCount, ps.str + "("));
			}
			if (ps.closeCount < ps.openCount) {
				queue.add(new ParanthesisString(ps.openCount, ps.closeCount + 1, ps.str + ")"));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// Set<String> balancedParanthesis = getBalancedParanthesis(4);
		// System.out.println(balancedParanthesis);
		// System.out.println(balancedParanthesis.size());

		System.out.println(getBalancedParanthesisOptimized(3));

	}

}
