package dsalgo.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LC_36_ValidSudoku {

	public boolean isValidSudoku(String[][] board) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String number = board[i][j];
				if (!number.equals(".")
						&& (!set.add(number + " At Row " + i) || !set.add(number + " At Col " + j)
								|| !set.add(number + " In Box " + (i / 3) + " - " + (j / 3)))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] matrix = { { "5", "3", ".", ".", "7", ".", ".", ".", "." },
				{ "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
				{ "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
				{ "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
				{ ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
	}

}
