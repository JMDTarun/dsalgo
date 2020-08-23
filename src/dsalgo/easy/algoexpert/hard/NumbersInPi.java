package dsalgo.easy.algoexpert.hard;

import java.util.Arrays;
import java.util.List;

public class NumbersInPi {

	public static int findMinimumSpacesToFormPi(List<String> list, String str, int start, int length) {
		if (start >= length) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int value = 0;
		int i = start;
		for (; i < length; i++) {
			String subString = str.substring(start, i);
			if (list.contains(subString)) {
				value = 1 + findMinimumSpacesToFormPi(list, str, i, length);
				min = Math.min(value, min);
			}
		}
		return Math.min(value, min);
	}

	public static void main(String[] args) {
		String str = "3141592";
		List<String> list = Arrays.asList(new String[] { "3141", "5", "31", "2", "4159", "9", "42" });
		System.out.println(findMinimumSpacesToFormPi(list, str, 0, str.length()));
	}

}
