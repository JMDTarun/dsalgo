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

	public static boolean isMatching(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.length() > 1 && p.charAt(1) == '*') {
			if (isMatching(s, p.substring(2))) {
				return true;
			}
			if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return isMatching(s.substring(1), p);
			}
			return false;
		} else {
			if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return isMatching(s.substring(1), p.substring(1));
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatching("aab", "c*a*b"));
		System.out.println(isMatching("mississippi", "mis*is*p*."));
		System.out.println(isMatching("ab", ".*"));
		System.out.println(isMatching("aa", "a"));
		System.out.println(isMatching("aab", ".*c"));
		System.out.println(isMatching("aaa", "ab*a"));
		System.out.println(isMatching("aa", "a*"));
		System.out.println(isMatching("a", "ab*a"));
		System.out.println(isMatching("aaa", "ab*a*c*a"));
		System.out.println(isMatching("aab", "b.*"));
		System.out.println(isMatching("aaaa", "a*a"));
		System.out.println(isMatching("aab", ".*.*"));
		System.out.println(isMatching("bab", "..*"));
		System.out.println(isMatching("baba", "b*.*"));

	}

}
