package dsalgo.easy.grokking.dp.lcs;

public class LongestPalindromicSubstring {

	public static int getLongestPalindromicSubsequence(String str, int i, int j, int count) {
		if (i > j) {
			return count;
		}

		if (i == j) {
			return (count + 1);
		}

		if (str.charAt(i) == str.charAt(j)) {
			count = getLongestPalindromicSubsequence(str, i + 1, j - 1, count + 2);
			System.out.println("Count is: " + count + ", str.charAt(i): " + str.charAt(i) + ", str.charAt(j): "
					+ str.charAt(j) + ", i: " + i + ", j: " + j);
			return Math.max(count, Math.max(getLongestPalindromicSubsequence(str, i + 1, j, 0),
					getLongestPalindromicSubsequence(str, i, j - 1, 0)));
		}

		return Math.max(getLongestPalindromicSubsequence(str, i + 1, j, 0),
				getLongestPalindromicSubsequence(str, i, j - 1, 0));
	}

	public static int getLongestPalindromicSubsequence1(String str, int i, int j, int count) {
		if (i > j) {
			return count;
		}

		if (i == j) {
			return (count + 1);
		}

		if (str.charAt(i) == str.charAt(j)) {
			count = getLongestPalindromicSubsequence1(str, i + 1, j - 1, count + 2);
			System.out.println("Count is: " + count + ", str.charAt(i): " + str.charAt(i) + ", str.charAt(j): "
					+ str.charAt(j) + ", i: " + i + ", j: " + j);
			return Math.max(count, Math.max(getLongestPalindromicSubsequence1(str, i + 1, j, 0),
					getLongestPalindromicSubsequence1(str, i, j - 1, 0)));
		}

		return Math.max(getLongestPalindromicSubsequence1(str, i + 1, j, 0),
				getLongestPalindromicSubsequence1(str, i, j - 1, 0));
	}

	public static void main(String[] args) {
		String str1 = "aa";
		System.out.println(getLongestPalindromicSubsequence(str1, 0, str1.length() - 1, 0));
	}

}
