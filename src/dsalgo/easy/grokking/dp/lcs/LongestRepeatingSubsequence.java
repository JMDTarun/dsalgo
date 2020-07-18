package dsalgo.easy.grokking.dp.lcs;

public class LongestRepeatingSubsequence {

	public static int getLongestRepeatingSubsequence(String str, int i, int j) {
		if (i == str.length() || j == str.length()) {
			return 0;
		}
		if (i != j && str.charAt(i) == str.charAt(j)) {
			return 1 + getLongestRepeatingSubsequence(str, i, j + 1);
		}
		return Math.max(getLongestRepeatingSubsequence(str, i + 1, j), getLongestRepeatingSubsequence(str, i, j + 1));
	}

	public static int getLongestRepeatingSubsequenceBottomUp(String str) {
		int cache[][] = new int[str.length() + 1][str.length() + 1];
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (j < i) {
					cache[i][j] = cache[i-1][j];
				} else {
					if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
						cache[i][j] = 1 + Math.max(cache[i - 1][j], cache[j - 1][i]);
					} else {
						cache[i][j] = Math.max(cache[i - 1][j], cache[i][j-1]);
					}
				}
				
			}
		}
		return cache[str.length()][str.length()];
	}

	public static void main(String[] args) {
		String str = "abcdabc";
		System.out.println(getLongestRepeatingSubsequence(str, 0, 0));
		System.out.println(getLongestRepeatingSubsequenceBottomUp(str));
	}

}
