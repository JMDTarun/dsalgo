package dsalgo.easy.grokking.dp.lcs;

public class MinimumNumberOfDeletionsAndInsertions {

	public static int getLongestCommonSubString(String str1, String str2, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return 1 + getLongestCommonSubString(str1, str2, i - 1, j - 1);
		}
		int max = 0;
		int maxValue = Math.max(getLongestCommonSubString(str1, str2, i - 1, j),
				getLongestCommonSubString(str1, str2, i, j - 1));
		return Math.max(max, maxValue);
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
					if (i <= str2.length() && j <= str1.length() && str2.charAt(i - 1) == str1.charAt(j - 1)
							&& i - j == 0) {
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
		String str1 = "pea";
		String str2 = "heap";
		int length = getLongestCommonSubStringBottomUp(str1, str2);
		System.out.println("Deletions = "+ (str2.length() - length));
		System.out.println("Insertions = "+ (str1.length() - length));
	}

}
