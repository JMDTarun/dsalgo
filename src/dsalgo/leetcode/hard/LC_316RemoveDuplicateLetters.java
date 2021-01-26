package dsalgo.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_316RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "cbacdcbc";
		LC_316RemoveDuplicateLetters rmd = new LC_316RemoveDuplicateLetters();
		System.out.println(rmd.removeDuplicateLetters(s));
	}

	public String removeDuplicateLetters(String s) {
		Set<Character> set = new HashSet<Character>();
		char[] charArray = s.toCharArray();
		for (Character c : charArray) {
			set.add(c);
		}
		Map<Character, Integer> newSet = new HashMap<Character, Integer>();
		StringBuilder strBuilder = new StringBuilder();
		int startWindow = 0;
		int endWindow = 0;
		String finalString = null;
		while (endWindow < s.length()) {
			if (newSet.containsKey(charArray[endWindow])) {
				String curStr = strBuilder.toString();
				Integer index = curStr.indexOf(charArray[endWindow]);
				strBuilder.replace(index, index + 1, "").append(charArray[endWindow]);
				String newStr = strBuilder.toString();
				if (newStr.compareTo(curStr) > 0) {
					Integer index1 = newStr.indexOf(charArray[endWindow]);
					strBuilder.replace(index1, index1 + 1, "");
					strBuilder.insert(index, charArray[endWindow]+"");
				} else {
					newSet.put(charArray[endWindow], endWindow);
				}
			} else {
				strBuilder.append(charArray[endWindow]);
				newSet.put(charArray[endWindow], endWindow);
			}
			if (strBuilder.length() == set.size()) {
				String tempStr = strBuilder.toString();
				if (finalString == null) {
					finalString = tempStr;
				} else {
					if (tempStr.compareTo(finalString) < 0) {
						finalString = tempStr;
					}
				}
//				newSet.remove(charArray[startWindow]);
				strBuilder.replace(0, 1, "");
				startWindow++;
			}
			endWindow++;
		}
		return finalString;
	}

}
