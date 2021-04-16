package dsalgo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionaryValidation {

	public boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			if (!compare(words[i], words[i + 1], map)) {
				return false;
			}
		}
		return true;
	}

	private boolean compare(String str1, String str2, Map<Character, Integer> map) {
		int l1 = str1.length();
		int l2 = str2.length();

		int i = 0;
		int j = 0;

		while (i < l1 && j < l2) {
			if (str1.charAt(i) != str2.charAt(j)) {
				if (map.get(str1.charAt(i)) < map.get(str2.charAt(j))) {
					return true;
				} else {
					return false;
				}
			}
			i++;
			j++;
		}
		if (l1 > l2) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "apple", "app" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
//		System.out.println(isAlienSorted(words, order));
	}

}
