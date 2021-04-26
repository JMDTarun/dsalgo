package dsalgo.leetcode.medium;

public class DecodeString {

	public static String decodeString(String s) {
		String result = null;
		String decodeStringHelper = decodeStringHelper(s);
		System.out.println(decodeStringHelper);
		return result;
	}

	private static int i = 0;

	private static String decodeStringHelper(String s) {
		StringBuilder result = new StringBuilder();
		while (i < s.length() && s.charAt(i) != ']') {
			if (Character.isDigit(s.charAt(i))) {
				int k = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					k = k * 10 + s.charAt(i++) - '0';
				}
				i++;
				String r = decodeStringHelper(s);
				while (k-- > 0) {
					result.append(r);
				}
				i++;
			} else {
				result.append(s.charAt(i++));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a2[c]]"));
	}

}
