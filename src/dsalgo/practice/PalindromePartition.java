package dsalgo.practice;

public class PalindromePartition {

	public static void main(String[] args) {
		String str = "nitin";
		printAllPlindromePartitions(str, str, 0, str.length(), str.length());
	}

	private static void printAllPlindromePartitions(String str, String s, int start, int end, int n) {
		if (s.equalsIgnoreCase("") || s.length() == 0) {
			return;
		}
		if (isPalindrome(s)) {
			System.out.println(str.substring(0, start) + " " + s + " " + str.substring(end, n));
		}
		printAllPlindromePartitions(str, s.substring(1), start + 1, end, n);
		printAllPlindromePartitions(str, s.substring(start, end - 1), start, end - 1, n);
	}

	private static boolean isPalindrome(String str) {
		boolean isPalindromeString = true;
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				isPalindromeString = false;
				break;
			}
			i++;
			j--;
		}
		return isPalindromeString;
	}

}
