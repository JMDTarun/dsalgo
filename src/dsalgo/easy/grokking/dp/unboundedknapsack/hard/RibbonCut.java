package dsalgo.easy.grokking.dp.unboundedknapsack.hard;

import java.util.ArrayList;
import java.util.List;

public class RibbonCut {

	// Polycarpus has a ribbon, its length is n. He wants to cut the ribbon in a way
	// that fulfils the following two conditions:
	//
	// After the cutting each ribbon piece should have length a, b or c.
	// After the cutting the number of ribbon pieces should be maximum.
	//
	// Help Polycarpus and find the number of ribbon pieces after the required
	// cutting.
	//
	// Constraints-
	// 1 <= n, a, b, c <= 4000 The numbers a, b and c can coincide.
	//
	// Problem Solution
	// This seems like a greedy problem but actually is a DP problem. We will create
	// an array dp[] to memoize values.
	//
	// dp[i]=number of ribbon peices for n=i
	//
	// We will initialize dp[0]=0 and then proceed in a bottom up fashion to
	// tabulate the array.
	//
	// Expected Input and Output
	// Case-1:
	//
	//
	// n=5
	// a=5
	// b=3
	// c=2
	//
	// Expected result=2 (5=3+2)
	// Case-2:
	//
	//
	// n=7
	// a=5
	// b=5
	// c=2
	//
	// Expected result=2 (7=5+2)
	// Case-3:
	//
	//
	// n=16
	// a=7
	// b=5
	// c=3
	//
	// Expected result=4 (16=7+3+3+3)

	int maxValue = Integer.MIN_VALUE;
	private static List<Integer> list = new ArrayList<Integer>();

	public static int cutRibbons(int[] sizes, int length) {
		if (length == 0) {
			System.out.println(list);
			return 0;
		}

		if (length < 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < sizes.length; i++) {
			if (length >= sizes[i]) {
				list.add(sizes[i]);
				int currentMax = cutRibbons(sizes, length - sizes[i]);
				if (currentMax != Integer.MIN_VALUE) {
					max = Math.max(max, currentMax + 1);
				}
				list.remove(list.size() - 1);
			}
		}
		return max;
	}

	public static int cutRibbonsTopDown(int[] sizes, int length) {
		int[] matrix1 = new int[length + 1];

		for (int i = 1; i <= length; i++) {
			matrix1[i] = Integer.MIN_VALUE;
		}

		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < sizes.length; j++) {
				if (i >= sizes[j]) {
					int max = matrix1[i - sizes[j]];
					if (max != Integer.MIN_VALUE) {
						matrix1[i] = Math.max(matrix1[i], 1 + max);
					}
				}
			}
		}
		return matrix1[length];
	}

	public static void main(String[] args) {
		System.out.println(cutRibbons(new int[] { 3, 5, 7 }, 16));
		System.out.println(cutRibbonsTopDown(new int[] { 3, 5, 7 }, 16));
	}

}
