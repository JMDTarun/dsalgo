package dsalgo.easy.grokking.dp.lcs;

public class PalindromePartitioning {

	public static boolean isPalindrome(String str, int i, int j) {
		boolean isPalindromeString = true;
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

	public static int palindromePartitioning(String str, int i, int j, Integer[][] cache) {
		if (i >= j) {
			return 0;
		}
		if (cache[i][j] != null) {
			return cache[i][j];
		}
		if (isPalindrome(str, i, j)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int minParitition = 1
					+ (palindromePartitioning(str, i, k, cache) + palindromePartitioning(str, k + 1, j, cache));
			min = Math.min(min, minParitition);
		}
		
		cache[i][j] = min;
		return cache[i][j];
	}

	public static void main(String[] args) {
		String str = "geek";
		Integer[][] cache = new Integer[str.length() + 1][str.length() + 1];
		System.out.println(palindromePartitioning(str, 0, str.length() - 1, cache));
	}

}
