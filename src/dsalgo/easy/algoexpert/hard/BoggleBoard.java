package dsalgo.easy.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

public class BoggleBoard {

	// Given a 2D board and a list of words from the dictionary, find all words in
	// the board.
	//
	// Each word must be constructed from letters of sequentially adjacent cell,
	// where "adjacent" cells are those horizontally or vertically neighboring. The
	// same letter cell may not be used more than once in a word.
	//
	// Example:
	//
	// Input:
	// board = [
	// ['o','a','a','n'],
	// ['e','t','a','e'],
	// ['i','h','k','r'],
	// ['i','f','l','v']
	// ]
	// words = ["oath","pea","eat","rain"]
	//
	// Output: ["eat","oath"]

	public static List<String> findWords(char[][] board, List<String> words) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				traverseGridForWord(String.valueOf(board[i][j]), i, j, board, words, result);
			}
		}
		return result;
	}

	public static void traverseGridForWord(String s, int i, int j, char[][] board, List<String> words,
			List<String> result) {
		if (i > board.length || j > board.length) {
			return;
		}
		if (i < 0 || j < 0) {
			return;
		}

		if (words.contains(s)) {
			result.add(s);
			return;
		}
		char c = board[i][j];
		board[i][j] = '*';
		// Up
		if (i - 1 > 0 && j > 0 && board[i - 1][j] != '*') {
			traverseGridForWord(s.concat(String.valueOf(board[i - 1][j])), i - 1, j, board, words, result);
		}

		// Down
		if (i + 1 < board.length && j < board.length && board[i + 1][j] != '*') {
			traverseGridForWord(s.concat(String.valueOf(board[i + 1][j])), i + 1, j, board, words, result);
		}

		// Left
		if (j + 1 < board.length && board[i][j + 1] != '*') {
			traverseGridForWord(s.concat(String.valueOf(board[i][j + 1])), i, j + 1, board, words, result);
		}

		// Right
		if (j - 1 > 0 && board[i][j - 1] != '*') {
			traverseGridForWord(s.concat(String.valueOf(board[i][j - 1])), i, j - 1, board, words, result);
		}
		board[i][j] = c;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		List<String> words = new ArrayList<String>();
		words.add("oath");
		words.add("pea");
		words.add("eat");
		words.add("rain");
		System.out.println(findWords(board, words));
	}

}
