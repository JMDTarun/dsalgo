package dsalgo.leetcode.hard;

import java.util.Stack;

public class LC_32_LongestValidParantesis {

	public static int longestValidParentheses(String s) {
		Stack<Integer> parentheses = new Stack<Integer>();
		parentheses.push(-1);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '(' && parentheses.size() > 1 && s.charAt(parentheses.peek()) == '(') {
				parentheses.pop();
				result = Math.max(result, i - parentheses.peek());
			} else
				parentheses.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("((()))"));
	}

}
