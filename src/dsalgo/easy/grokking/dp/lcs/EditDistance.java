package dsalgo.easy.grokking.dp.lcs;

public class EditDistance {

	public static int getEditDistance(String str1, String str2, int i, int j, Integer[][] cache) {
		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}

		if (cache[i][j] != null) {
			return cache[i][j];
		}

		if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
			return getEditDistance(str1, str2, i - 1, j - 1, cache);
		}

		int minForInsert = getEditDistance(str1, str2, i, j - 1, cache);
		int minForDelete = getEditDistance(str1, str2, i - 1, j, cache);
		int minForReplace = getEditDistance(str1, str2, i - 1, j - 1, cache);

		if (minForInsert <= minForReplace && minForInsert <= minForDelete) {
			cache[i][j] = 1 + minForInsert;
		} else if (minForDelete <= minForInsert && minForDelete <= minForReplace) {
			cache[i][j] = 1 + minForDelete;
		} else {
			cache[i][j] = 1 + minForReplace;
		}
		return cache[i][j];
	}

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		Integer[][] cache = new Integer[str1.length() + 1][str2.length() + 1];
		System.out.println(getEditDistance(str1, str2, str1.length(), str2.length(), cache));
	}

}
