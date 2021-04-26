package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		List<String> response = new ArrayList<String>();
		String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		letterCombinationsHelper("", digits, 0, arr, response);
		return response;
	}

	public static void letterCombinationsHelper(String prefix, String digits, int start, String[] arr,
			List<String> response) {
		if (start >= digits.length()) {
			response.add(prefix);
			return;
		}

		int index = Character.getNumericValue(digits.charAt(start));
		String letters = arr[index];
		for (int i = 0; i < letters.length(); i++) {
			letterCombinationsHelper(prefix + letters.charAt(i), digits, start + 1, arr, response);
		}
	}

	public static List<String> letterCombinationsUsingQueue(String digits) {
		List<String> response = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return response;
		}

		String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		int start = 0;
		int index = Character.getNumericValue(digits.charAt(start));
		String letters = arr[index];
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < letters.length(); i++) {
			queue.add(String.valueOf(letters.charAt(i)));
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			start++;
			for (int i = 0; i < size; i++) {
				String poll = queue.poll();
				if (poll.length() == digits.length()) {
					response.add(poll);
				} else {
					index = Character.getNumericValue(digits.charAt(start));
					letters = arr[index];
					for (int j = 0; j < letters.length(); j++) {
						String concat = poll.concat(String.valueOf(letters.charAt(j)));
						if (concat.length() == digits.length()) {
							response.add(concat);
						} else {
							queue.add(concat);
						}

					}
				}
			}
		}

		return response;
	}

	public static void main(String[] args) {
		letterCombinationsUsingQueue("234");
	}

}
