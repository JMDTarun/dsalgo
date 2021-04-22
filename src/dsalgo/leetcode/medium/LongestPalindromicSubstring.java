package dsalgo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		Map<String, Boolean> set = new HashMap<>();
		return getPlindrome(s, 0, s.length(), set);
	}

	public static String getPlindrome(String s, int start, int end, Map<String, Boolean> set) {
		if (start > end || s == null) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		String subStr = s.substring(start, end);
		if (set.containsKey(subStr)) {
			if (set.get(subStr)) {
				return subStr;
			} else {
				return "";
			}
		}

		if (isPalindrome(subStr)) {
			set.put(subStr, true);
			return subStr;
		} else {
			set.put(subStr, false);
		}

		String longestPalindrome = "";

		String p1 = getPlindrome(s, start, end - 1, set);
		String p2 = getPlindrome(s, start + 1, end, set);

		if (p1 != null && p1.length() > longestPalindrome.length()) {
			longestPalindrome = p1;
		}

		if (p2 != null && p2.length() > longestPalindrome.length()) {
			longestPalindrome = p2;
		}
		return longestPalindrome;
	}

	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
