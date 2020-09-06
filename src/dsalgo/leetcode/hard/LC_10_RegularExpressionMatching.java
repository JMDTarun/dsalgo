package dsalgo.leetcode.hard;

public class LC_10_RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {

		if (s.length() == 0 && p.length() == 0) {
			return true;
		}

		if (s.length() != 0 && p.length() == 0) {
			return false;
		}

		boolean isValid = true;

		while (s.length() > 0 && p.length() > 0) {
			if (s.charAt(0) != p.charAt(0)) {
				if (p.charAt(0) != '.' && p.length() > 1 && p.charAt(1) != '*') {
					isValid = false;
					break;
				} else if (p.charAt(0) == '.') {
					s = s.substring(1);
					if ((p.length() > 1 && p.charAt(1) != '*') || (p.length() == 1)) {
						p = p.substring(1);
					}
				} else if (p.length() > 1 && p.charAt(1) == '*') {
					p = p.substring(2);
				} else {
					isValid = false;
					break;
				}
			} else {
				char charAt = s.charAt(0);
				s = s.substring(1);
				if ((p.length() > 1 && p.charAt(1) == '*')) {
					p = p.substring(2);
				} else if (p.length() == 1) {
					p = p.substring(1);
				}
				while (s.charAt(0) == charAt) {
					s = s.substring(1);
				}
			}
		}
		if (s.length() > 0 || (s.length() == 0 && p.length() > 2) || (s.length() == 0 && p.length() == 1)) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isMatch1(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		} else if (p.length() == 1) {
			if (s.length() == 1 && isFirstCharMatch(s, p)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (p.charAt(1) == '*') {
				while (s.length() > 0 && isFirstCharMatch(s, p)) {
					if (isMatch1(s, p.substring(2))) { // for example, a* eats aaa or .* eats abc.
						return true;
					}
					s = s.substring(1);
				}
				return isMatch1(s, p.substring(2));
			} else {
				if (s.length() > 0 && isFirstCharMatch(s, p)) {
					return isMatch1(s.substring(1), p.substring(1));
				} else {
					return false;
				}
			}
		}
	}

	private static boolean isFirstCharMatch(String s, String p) {
		return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
	}

	public static void main(String[] args) {
		String s = "aa";
		String p = "a*";

		System.out.println(isMatch(s, p));

	}

}
