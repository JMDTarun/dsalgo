package dsalgo.easy.algoexpert.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RiverSizes {

	// Given a 2d grid map of '1's (land) and '0's (water), count the number of
	// islands. An island is surrounded by water and is formed by connecting
	// adjacent lands horizontally or vertically. You may assume all four edges of
	// the grid are all surrounded by water.
	//
	//
	//
	// Example 1:
	//
	// Input: grid = [
	// ["1","1","1","1","0"],
	// ["1","1","0","1","0"],
	// ["1","1","0","0","0"],
	// ["0","0","0","0","0"]
	// ]
	// Output: 1
	// Example 2:
	//
	// Input: grid = [
	// ["1","1","0","0","0"],
	// ["1","1","0","0","0"],
	// ["0","0","1","0","0"],
	// ["0","0","0","1","1"]
	// ]
	// Output: 3

	public static int getRiverSizes(int[][] matrix) {
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != -1 && matrix[i][j] == 1) {
					counter += 1;
					traverseMatrix(matrix, i, j);
				}
			}
		}
		return counter;
	}

	private static void traverseMatrix(int[][] matrix, int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			matrix[poll[0]][poll[1]] = -1;
			if (poll[0] - 1 > 0 && matrix[poll[0] - 1][poll[1]] != -1 && matrix[poll[0] - 1][poll[1]] == 1) {
				queue.add(new int[] { poll[0] - 1, poll[1] });
			}
			if (poll[0] + 1 < matrix.length && matrix[poll[0] + 1][poll[1]] != -1
					&& matrix[poll[0] + 1][poll[1]] == 1) {
				queue.add(new int[] { poll[0] + 1, poll[1] });
			}
			if (poll[1] - 1 > 0 && matrix[poll[0]][poll[1] - 1] != -1 && matrix[poll[0]][poll[1] - 1] == 1) {
				queue.add(new int[] { poll[0], poll[1] - 1 });
			}
			if (poll[1] + 1 < matrix[i].length && matrix[poll[0]][poll[1] + 1] != -1
					&& matrix[poll[0]][poll[1] + 1] == 1) {
				queue.add(new int[] { poll[0], poll[1] + 1 });
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(getRiverSizes(matrix));
		System.out.println(getRiverSizes(new int[][] { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }));
	}

}
