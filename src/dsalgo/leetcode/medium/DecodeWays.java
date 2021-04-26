package dsalgo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	public static int numDecodings(String s) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = numDecodingsDfs(s, "", 0, map);
		return sum;
	}

	public static int numDecodingsDfs(String s, String prefix, int start, Map<Integer, Integer> map) {
		if (start > s.length()) {
			return 0;
		}

		if (prefix != null && prefix.length() > 0) {
			if (prefix.charAt(0) == '0' || prefix.length() > 3 || Integer.parseInt(prefix) > 26) {
				return 0;
			}
		}

		if (map.containsKey(start)) {
			return map.get(start);
		}

		if (start == s.length()) {
			return 1;
		}

		int sum = 0;
		for (int i = start; i < s.length(); i++) {
			String concat = s.substring(start, i + 1);
			sum += numDecodingsDfs(s, concat, i + 1, map);
		}
		map.put(start, sum);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
	}

}
