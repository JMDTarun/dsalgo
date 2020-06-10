package dsalgo.easy.grokking.subsets.hard;

public class CountOfStructurallyUniqueBinarySearchTrees {

	public static int countTrees(int start, int end) {
		if (start > end) {
			return 1;
		}
		int treesCount = 0;
		for (int i = start; i <= end; i++) {
			int leftTrees = countTrees(start, i - 1);
			int rightTrees = countTrees(i + 1, end);
			treesCount += (leftTrees * rightTrees);
		}
		return treesCount;
	}

	public static int countTrees(int n) {
		return countTrees(1, n);
	}

	public static void main(String[] args) {
		System.out.println(countTrees(3));
	}

}
