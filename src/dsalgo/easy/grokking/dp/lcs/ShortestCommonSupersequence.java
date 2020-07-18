package dsalgo.easy.grokking.dp.lcs;

public class ShortestCommonSupersequence {
	public static int getLongestCommonSubSequence(String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestCommonSubSequence(str1, str2, i - 1, j - 1);
		}
		return Math.max(getLongestCommonSubSequence(str1, str2, i - 1, j),
				getLongestCommonSubSequence(str1, str2, i, j - 1));
	}

	public static int getLongestCommonSubSequence1(String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestCommonSubSequence(str1, str2, i - 1, j - 1);
		}
		return Math.max(getLongestCommonSubSequence(str1, str2, i - 1, j),
				getLongestCommonSubSequence(str1, str2, i, j - 1));
	}

	public static int getLongestCommonSubSequenceBottomUp(String str1, String str2) {
		int matrix[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (j < i) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					if (i <= str2.length() && j <= str1.length() && str2.charAt(i - 1) == str1.charAt(j - 1)) {
						matrix[i][j] = 1 + Math.max(matrix[i - 1][j], matrix[j - 1][i]);
					} else {
						matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
					}
				}

			}
		}
		return matrix[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String str1 = "geeks";
		String str2 = "eke";
		int length = getLongestCommonSubSequence(str1, str2, str1.length(), str2.length());
		System.out.println(str1.length() + str2.length() - length);
		length = getLongestCommonSubSequenceBottomUp(str1, str2);
		System.out.println(str1.length() + str2.length() - length);
	}

}
