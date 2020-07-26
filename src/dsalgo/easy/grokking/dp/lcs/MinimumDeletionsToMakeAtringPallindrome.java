package dsalgo.easy.grokking.dp.lcs;

public class MinimumDeletionsToMakeAtringPallindrome {

	public static int getLongestPalindromicSubsequence(String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestPalindromicSubsequence(str1, str2, i - 1, j - 1);
		}
		return Math.max(getLongestPalindromicSubsequence(str1, str2, i - 1, j),
				getLongestPalindromicSubsequence(str1, str2, i, j - 1));
	}

	public static int getLongestPalindromicSubsequenceTopDown(Integer[][] cache, String str1, String str2, int i,
			int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (cache[i][j] != null) {
			return cache[i][j];
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestPalindromicSubsequenceTopDown(cache, str1, str2, i - 1, j - 1);
		}
		int max = Math.max(getLongestPalindromicSubsequenceTopDown(cache, str1, str2, i - 1, j),
				getLongestPalindromicSubsequenceTopDown(cache, str1, str2, i, j - 1));
		cache[i][j] = max;
		return cache[i][j];
	}

	public static void main(String[] args) {
		String str1 = "aebcbda";
		String str2 = "adbcbea";
		System.out.println(getLongestPalindromicSubsequence(str1, str2, str1.length(), str2.length()));
		Integer[][] cache = new Integer[str1.length() + 1][str2.length() + 1];
		System.out.println(getLongestPalindromicSubsequenceTopDown(cache, str1, str2, str1.length(), str2.length()));
		System.out.println(str1.length() - getLongestPalindromicSubsequenceTopDown(cache, str1, str2, str1.length(), str2.length()));
	}

}
