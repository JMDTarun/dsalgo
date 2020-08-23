package dsalgo.easy.algoexpert.hard;

import java.util.Stack;

public class RegexMatcher {

	// Given an input string (s) and a pattern (p), implement regular expression
	// matching with support for '.' and '*'.
	//
	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	// The matching should cover the entire input string (not partial).
	//
	// Note:
	//
	// s could be empty and contains only lowercase letters a-z.
	// p could be empty and contains only lowercase letters a-z, and characters like
	// . or *.
	// Example 1:
	//
	// Input:
	// s = "aa"
	// p = "a"
	// Output: false
	// Explanation: "a" does not match the entire string "aa".
	// Example 2:
	//
	// Input:
	// s = "aa"
	// p = "a*"
	// Output: true
	// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
	// by repeating 'a' once, it becomes "aa".
	// Example 3:
	//
	// Input:
	// s = "ab"
	// p = ".*"
	// Output: true
	// Explanation: ".*" means "zero or more (*) of any character (.)".
	// Example 4:
	//
	// Input:
	// s = "aab"
	// p = "c*a*b"
	// Output: true
	// Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
	// it matches "aab".
	// Example 5:
	//
	// Input:
	// s = "mississippi"
	// p = "mis*is*p*."
	// Output: false

	public static boolean isMatch(String s, String p) {
		char[] pattern = p.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < p.length(); i++) {
			stack.push(pattern[i]);
		}

		int start = s.length() - 1;
		Character precedingCharacter = null;
		while (start >= 0 && !stack.isEmpty()) {
			Character pop = stack.pop();
			precedingCharacter = null;
			if (pop.charValue() == '*') {
				precedingCharacter = stack.pop();
				if (precedingCharacter.charValue() == '.') {
					if (stack.isEmpty()) {
						return true;
					} else {
						Character reachUpto = stack.peek();
						if (reachUpto.charValue() != '*' && reachUpto.charValue() != '.') {
							while (start >= 0 && s.charAt(start) != reachUpto.charValue()) {
								start--;
							}
						} else {
							while (!stack.isEmpty() && start >= 0 && stack.peek() == '*' || stack.peek() == '.') {
								if (stack.peek() == '*' || stack.peek() == '.') {
									stack.pop();
								}
								start--;
							}
						}
					}
				} else {
					if (s.charAt(start) != precedingCharacter.charValue()) {
						// start--;
					} else {
						while (start >= 0 && s.charAt(start) == precedingCharacter.charValue()) {
							start--;
						}
					}
				}
			} else if (pop.charValue() == '.') {
				start--;
			} else {
				if (pop.charValue() != s.charAt(start)) {
					return false;
				}
				start--;
			}
		}
		while (start < 0 && !stack.isEmpty()) {
			Character pop = stack.pop();
			if (pop.charValue() == '*') {
				stack.pop();
			} else if (precedingCharacter != null) {
				if (precedingCharacter.charValue() != pop.charValue()) {
					return false;
				}
			} else {
				return false;
			}
		}
		return start >= 0 && stack.isEmpty() ? false : true;
	}

	public static boolean isMatch1(String s, String p) {

		char[] pattern = p.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (int i = p.length() - 1; i >= 0; i--) {
			stack.push(pattern[i]);
		}

		int start = 0;

		while (start < s.length() && !stack.isEmpty()) {
			Character pop = stack.pop();
			if (pop.charValue() == '.') {
				Character peek = stack.isEmpty() ? null : stack.peek();
				if (peek != null && peek.charValue() == '*') {
					stack.pop();
					char c = s.charAt(start);
					while (start < s.length() && s.charAt(start) != c) {
						start++;
					}
				} else {
					start++;
				}
			} else if (pop.charValue() == s.charAt(start)) {
				Character peek = stack.isEmpty() ? null : stack.peek();
				if (peek != null && peek.charValue() == '*') {
					stack.pop();
					while (start < s.length() && s.charAt(start) == pop.charValue()) {
						start++;
					}
				} else {
					start++;
				}
			} else if (!stack.isEmpty() && stack.peek() == '*') {
				stack.pop();
				char c = s.charAt(start);
				while (start < s.length() && s.charAt(start) != c) {
					start++;
				}
			} else {
				return false;
			}
		}

		while (!stack.isEmpty()) {
			if (start >= s.length() && stack.peek() != '*') {
				stack.pop();
				if (!stack.isEmpty() && stack.peek() != '*') {
					return false;
				}
			}
			if (!stack.isEmpty()) {
				stack.pop();
			}
		}

		return start < s.length() && stack.isEmpty() ? false : true;
	}

	public static void main(String[] args) {
		// System.out.println(isMatch1("aab", "c*a*b"));
		// System.out.println(isMatch1("mississippi", "mis*is*p*."));
		// System.out.println(isMatch1("ab", ".*"));
		// System.out.println(isMatch1("aa", "a"));
		// System.out.println(isMatch1("aab", ".*c"));
		// System.out.println(isMatch1("aaa", "ab*a"));
		// System.out.println(isMatch1("aa", "a*"));
		// System.out.println(isMatch1("a", "ab*a"));
//		System.out.println(isMatch1("aaa", "ab*a*c*a"));
//		 System.out.println(isMatch1("aab", "b.*"));
		 System.out.println(isMatch1("aasdfasdfasdfasdfas",
		 "aasdf.*asdf.*asdf.*asdf.*s"));
		// System.out.println(isMatch1("aab", ".*.*"));
		// System.out.println(isMatch1("bab", "..*"));
		// System.out.println(isMatch1("baba", "b*.*"));

	}

}
