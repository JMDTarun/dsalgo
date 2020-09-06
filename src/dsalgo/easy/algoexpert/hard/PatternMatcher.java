package dsalgo.easy.algoexpert.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatternMatcher {

	public static boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() == 0 && str.length() == 0) {
			return true;
		}
		if (pattern.length() == 0) {
			return false;
		}

		Map<Character, String> map = new HashMap<Character, String>();

		return helper(pattern, str, 0, 0, map);
	}

	public static boolean helper(String pattern, String str, int i, int j, Map<Character, String> map) {
		if (i == pattern.length() && j == str.length()) {
			return true;
		}

		if (i >= pattern.length() || j >= str.length()) {
			return false;
		}

		char c = pattern.charAt(i);
		for (int k = j + 1; k <= str.length(); k++) {
			String sub = str.substring(j, k);
			if (!map.containsKey(c) && !map.containsValue(sub)) {
				map.put(c, sub);
				if (helper(pattern, str, i + 1, k, map))
					return true;
				map.remove(c);
			} else if (map.containsKey(c) && map.get(c).equals(sub)) {
				if (helper(pattern, str, i + 1, k, map))
					return true;
			}
		}
		return false;
	}

	private static Map<Character, String> map = new HashMap<>();
	private static Set<String> set = new HashSet<String>();

	public static boolean wordPatternMatch1(String pattern, String str) {
		if (pattern.isEmpty())
			return str.isEmpty();
		if (map.containsKey(pattern.charAt(0))) {
			String value = map.get(pattern.charAt(0));
			if (str.length() < value.length() || !str.substring(0, value.length()).equals(value))
				return false;
			if (wordPatternMatch1(pattern.substring(1), str.substring(value.length())))
				return true;
		} else {
			for (int i = 1; i <= str.length(); i++) {
				if (set.contains(str.substring(0, i)))
					continue;
				map.put(pattern.charAt(0), str.substring(0, i));
				set.add(str.substring(0, i));
				if (wordPatternMatch1(pattern.substring(1), str.substring(i)))
					return true;
				set.remove(str.substring(0, i));
				map.remove(pattern.charAt(0));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(wordPatternMatch("abba", "redratratred"));
		System.out.println(wordPatternMatch1("aabb", "rrrrrrratrat"));
	}

}
