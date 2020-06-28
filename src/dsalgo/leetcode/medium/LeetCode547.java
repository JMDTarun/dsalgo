package dsalgo.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode547 {
	public static int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) {
			return 0;
		}

		int N = M.length;

		boolean[] visited = new boolean[N];
		int numCC = 0;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				numCC += 1;
				bfs(i, M, visited);
			}
		}
		return numCC;
	}

	private static void bfs(int row, int[][] M, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		int N = M.length;

		queue.offer(row);
		visited[row] = true;

		while (!queue.isEmpty()) {
			int currRow = queue.poll();
			for (int neighbor = 0; neighbor < N; neighbor++) {
				if (M[currRow][neighbor] == 1 && !visited[neighbor]) {
					queue.offer(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(findCircleNum(matrix));
		int[][] matrix1 = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		System.out.println(findCircleNum(matrix1));
	}
}
