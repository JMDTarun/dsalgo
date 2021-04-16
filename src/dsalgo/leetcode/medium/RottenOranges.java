package dsalgo.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static int orangesRotting(int[][] grid) {
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		Queue<Pair> queue = new LinkedList<Pair>();
		int freshOranges = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				} else if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		if (freshOranges == 0) {
			return 0;
		}
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair poll = queue.poll();
				if (poll.getM() + 1 < m && grid[poll.getM() + 1][poll.getN()] == 1) {
					grid[poll.getM() + 1][poll.getN()] = 2;
					queue.add(new Pair(poll.getM() + 1, poll.getN()));
					freshOranges--;
				}

				if (poll.getM() - 1 >= 0 && grid[poll.getM() - 1][poll.getN()] == 1) {
					grid[poll.getM() - 1][poll.getN()] = 2;
					queue.add(new Pair(poll.getM() - 1, poll.getN()));
					freshOranges--;
				}

				if (poll.getN() + 1 < n && grid[poll.getM()][poll.getN() + 1] == 1) {
					grid[poll.getM()][poll.getN() + 1] = 2;
					queue.add(new Pair(poll.getM(), poll.getN() + 1));
					freshOranges--;
				}

				if (poll.getN() - 1 >= 0 && grid[poll.getM()][poll.getN() - 1] == 1) {
					grid[poll.getM()][poll.getN() - 1] = 2;
					queue.add(new Pair(poll.getM(), poll.getN() - 1));
					freshOranges--;
				}
			}
		}

		return freshOranges == 0 ? count - 1 : -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		orangesRotting(grid);
	}

}

class Pair {
	private int m;
	private int n;

	public Pair(int m, int n) {
		this.m = m;
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
