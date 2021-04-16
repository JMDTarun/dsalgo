package dsalgo.leetcode.medium;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

	public static String removeDuplicates(String s, int k) {
		if (s == null || k == 1) {
			return "";
		}
		if (s.length() < k) {
			return s;
		}
		Stack<int[]> stack = new Stack<>();
		int arr[] = new int[2];
		arr[0] = s.charAt(0);
		arr[1] = 1;
		stack.push(arr);
		int start = 1;
		while (start < s.length()) {
			int[] peek = stack.isEmpty() ? null : stack.peek();
			if (peek != null && peek[0] == s.charAt(start)) {
				int count = ++peek[1];
				if (count == k) {
					while (count - 1 > 0) {
						stack.pop();
						count--;
					}
				} else {
					int temp[] = new int[2];
					temp[0] = s.charAt(start);
					temp[1] = count;
					stack.push(temp);
				}
			} else {
				int temp[] = new int[2];
				temp[0] = s.charAt(start);
				temp[1] = 1;
				stack.push(temp);
			}
			start++;
		}
		StringBuilder strBuilder = new StringBuilder();
		for (int[] a : stack) {
			strBuilder.append((char) a[0]);
		}
		return strBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
	}

}
