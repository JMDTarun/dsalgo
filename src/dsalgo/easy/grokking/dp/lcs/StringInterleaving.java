package dsalgo.easy.grokking.dp.lcs;

public class StringInterleaving {

	public static boolean isStringInterleaving(String a, String b, int i, int j) {
		if (i == a.length()) {
			return true;
		}
		if (j == b.length() && i < a.length()) {
			return false;
		}
		if (a.charAt(i) == b.charAt(j)) {
			return isStringInterleaving(a, b, i + 1, j + 1);
		}
		return isStringInterleaving(a, b, i, j + 1);
	}

	public static boolean isStringInterleaving(String a, String b, String c) {
		return isStringInterleaving(a, c, 0, 0) && isStringInterleaving(b, c, 0, 0);
	}

	public static void main(String[] args) {
		String a = "XXY";
		String b = "YX";
		String c = "X";

		System.out.println(isStringInterleaving(a, b, c));
	}

}
