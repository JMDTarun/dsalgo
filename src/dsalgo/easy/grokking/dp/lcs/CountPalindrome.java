package dsalgo.easy.grokking.dp.lcs;

public class CountPalindrome {
	public static boolean isPalindrome(String str, int i, int j) {
		boolean isPalindome = true;
		if (i > j) {
			return false;
		}
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				isPalindome = false;
				break;
			}
			i++;
			j--;
		}
		return i > j && isPalindome ? true : false;
	}

	public static int getPalindromesCount(String str, int i, int j) {
		if (i >= str.length()) {
			return 0;
		}
		if (j <= 0) {
			return 0;
		}
		int count = 0;
		if (isPalindrome(str, i, j)) {
			System.out.println("Got Palindrome String at:: i: " + i + ", j: " + j);
			count++;
		}
		getPalindromesCount(str, i + 1, j);
		getPalindromesCount(str, i, j - 1);
		return count;
	}

	public static void main(String[] args) {
		String str = "geek";
		Integer[][] cache = new Integer[str.length() + 1][str.length() + 1];
		System.out.println(getPalindromesCount(str, 0, str.length() - 1));
	}

}
