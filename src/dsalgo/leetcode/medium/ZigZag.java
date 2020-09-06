package dsalgo.leetcode.medium;

public class ZigZag {

	public static String zigzagPattern(String s, int nRows) {
		StringBuilder[] sb = new StringBuilder[nRows];
		int n = s.length();
		int i = 0;

		for (int k = 0; k < sb.length; k++)
			sb[k] = new StringBuilder();

		while (i < n) {
			for (int j = 0; j < nRows && i < n; j++)         // Move Vertically Down
				sb[j].append(s.charAt(i++));
			for (int j = nRows - 2; j >= 1 && i < n; j--)    // Move Obliquely Up
				sb[j].append(s.charAt(i++));
		}
		return String.join("", sb);
	}

	public static void main(String[] args) {
		System.out.println(zigzagPattern("PAYPALISHIRING", 4));
	}

}
