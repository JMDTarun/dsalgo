package dsalgo.common;

import java.util.Arrays;

public class AlgoUtil {

	public static void print2D(int mat[][]) {
		System.out.println();
		System.out.println();
		for (int[] row : mat) {
			System.out.println(Arrays.toString(row));
		}
	}
	
}
