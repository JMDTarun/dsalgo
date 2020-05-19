package dsalgo.easy.grokking.subsets.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

	public static void main(String[] args) {
		Set<String> balancedParanthesis = getBalancedParanthesis(4);
		System.out.println(balancedParanthesis);
		System.out.println(balancedParanthesis.size());
	}

}
