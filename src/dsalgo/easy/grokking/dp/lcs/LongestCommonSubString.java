package dsalgo.easy.grokking.dp.lcs;

public class LongestCommonSubString {

	public static int getLongestCommonSubStringLength(String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestCommonSubStringLength(str1, str2, i - 1, j - 1);
		}
		int max = 0;
		int maxValue = Math.max(getLongestCommonSubStringLength(str1, str2, i - 1, j),
				getLongestCommonSubStringLength(str1, str2, i, j - 1));
		return Math.max(max, maxValue);
	}

	private static String longestSubString = "";
	
	public static String getLongestCommonSubString(String str1, String str2, int i, int j, String s) {
		if (i == 0 || j == 0) {
			return "";
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			s = s.concat(String.valueOf(str1.charAt(i - 1)));
			System.out.println(s);
			return s + getLongestCommonSubString(str1, str2, i - 1, j - 1, s);
		}
		String value = "";
		String longest = null;
		String val1 = getLongestCommonSubString(str1, str2, i - 1, j, s);
		String val2 = getLongestCommonSubString(str1, str2, i, j - 1, s);
		if (val1.length() > val2.length()) {
			longest = val1;
		} else {
			longest = val2;
		}
		if (value.length() > longest.length()) {
			return value;
		} else {
			return longest;
		}
		// return Math.max(max, maxValue);
	}
	
	public static int getLongestCommonSubStringBottomUp(String str1, String str2) {
		int matrix[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < matrix.length; i++) {
			int max = 0;
			for (int j = 1; j < matrix[i].length; j++) {
				int maxValue = 0;
				if (j < i) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					if (i <= str2.length() && j <= str1.length() && str2.charAt(i - 1) == str1.charAt(j - 1)) {
						maxValue = 1 + matrix[i - 1][j - 1];
					} else {
						maxValue = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
					}
				}
				matrix[i][j] = Math.max(max, maxValue);
			}
		}
		return matrix[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String str1 = "abacca";
		String str2 = "accaba";
		System.out.println(getLongestCommonSubStringLength(str1, str2, str1.length(), str2.length()));
		System.out.println(getLongestCommonSubStringBottomUp(str1, str2));
		System.out.println(getLongestCommonSubString(str1, str2, str1.length(), str2.length(), ""));
	}

}
