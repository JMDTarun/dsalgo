package dsalgo.leetcode.medium;

public class UniqueBinarySearchTrees {

	public static int numTrees(int n) {
		return numTreesHelper(1, n);
	}

	private static int numTreesHelper(int start, int end) {
		if (start > end) {
			return 1;
		}
		int numberOfTrees = 0;
		for (int i = start; i <= end; i++) {
			int left = numTreesHelper(start, i - 1);
			int right = numTreesHelper(i + 1, end);
			numberOfTrees += (left * right);
		}
		return numberOfTrees;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}

}
