package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<String> tempList = new ArrayList<String>();
		restoreIpAddressesHelper(s, 0, result, 0, tempList);
		return result;
	}

	public static void restoreIpAddressesHelper(String s, int start, List<String> result, int counter,
			List<String> tempList) {
		if (counter == 4 && start < s.length()) {
			return;
		}

		if (counter == 4 && start == s.length()) {
			result.add(String.join(".", tempList));
		}

		for (int i = start; i < s.length(); i++) {
			counter++;
			String substring = s.substring(start, i + 1);
			int parseInt = Integer.parseInt(substring);
			if (parseInt > 255 || substring.length() > String.valueOf(parseInt).length()) {
				break;
			}
			tempList.add(substring);
			restoreIpAddressesHelper(s, i + 1, result, counter, tempList);
			tempList.remove(tempList.size() - 1);
			counter--;
		}
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("101023"));
	}

}
