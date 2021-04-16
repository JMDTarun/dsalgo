package dsalgo.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	private static int directions[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 }, { 1, 1 } };

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
			return -1;
		}
		boolean[][] cache = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0 });
		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				if (poll[0] == m - 1 && poll[1] == n - 1) {
					return ans + 1;
				}
				for (int d = 0; d < 8; d++) {
					int x = directions[d][0] + poll[0];
					int y = directions[d][1] + poll[1];

					if (x >= 0 && x < m && y >= 0 && y < n && !cache[x][y] && grid[x][y] == 0) {
						queue.add(new int[] { x, y });
						cache[x][y] = true;
					}
				}
			}
			ans++;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 1, 0 } };
		System.out.println(shortestPathBinaryMatrix(grid));
	}

	
	
	
//	class Solution {
//	    public static int shortestPathBinaryMatrix(int[][] grid) {
//			int m = grid.length;
//			int n = grid[0].length;
//			if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
//				return -1;
//			}
//			int[][] cache = new int[m][n];
//			boolean[][] visited = new boolean[m][n];
//			int min = shortestPath(grid, 0, 0, m, n, cache, visited);
//			return min == Integer.MAX_VALUE ? -1 : min + 1;
//		}
//
//		public static int shortestPath(int[][] arr, int i, int j, int m, int n, int[][] cache, boolean[][] visited) {
//			if (i >= m || j >= n || i < 0 || j < 0 || arr[i][j] == 1 || visited[i][j]) {
//				return Integer.MAX_VALUE;
//			}
//
//			if (i == m - 1 && j == n - 1) {
//				return 0;
//			}
//
//			visited[i][j] = true;
//			if (cache[i][j] > 0) {
//				return cache[i][j];
//			}
//
//			int min = Integer.MAX_VALUE;
//
//			int a = shortestPath(arr, i - 1, j - 1, m, n, cache, visited);
//			if (a != Integer.MAX_VALUE) {
//				a = a + 1;
//			}
//			int b = shortestPath(arr, i, j - 1, m, n, cache, visited);
//			if (b != Integer.MAX_VALUE) {
//				b = b + 1;
//			}
//			int c = shortestPath(arr, i + 1, j - 1, m, n, cache, visited);
//			if (c != Integer.MAX_VALUE) {
//				c = c + 1;
//			}
//			int d = shortestPath(arr, i - 1, j, m, n, cache, visited);
//			if (d != Integer.MAX_VALUE) {
//				d = d + 1;
//			}
//			int e = shortestPath(arr, i, j + 1, m, n, cache, visited);
//			if (e != Integer.MAX_VALUE) {
//				e = e + 1;
//			}
//			int f = shortestPath(arr, i - 1, j + 1, m, n, cache, visited);
//			if (f != Integer.MAX_VALUE) {
//				f = f + 1;
//			}
//			int g = shortestPath(arr, i + 1, j + 1, m, n, cache, visited);
//			if (g != Integer.MAX_VALUE) {
//				g = g + 1;
//			}
//			int h = shortestPath(arr, i + 1, j, m, n, cache, visited);
//			if (h != Integer.MAX_VALUE) {
//				h = h + 1;
//			}
//			min = Math.min(min,
//					Math.min(a, Math.min(b, Math.min(c, Math.min(d, Math.min(e, Math.min(f, Math.min(g, h))))))));
//			cache[i][j] = min;
//			visited[i][j] = false;
//			return min;
//
//		}
//	}
}
