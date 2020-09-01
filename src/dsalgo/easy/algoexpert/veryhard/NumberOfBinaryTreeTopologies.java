package dsalgo.easy.algoexpert.veryhard;

public class NumberOfBinaryTreeTopologies {

	public static int countNumberOfBinaryTrees(int start, int end) {
		if (start > end) {
			return 1;
		}
		int totalTrees = 0;
		for (int i = start; i <= end; i++) {
			int countLeftTrees = countNumberOfBinaryTrees(start, i - 1);
			int countRightTrees = countNumberOfBinaryTrees(i + 1, end);
			totalTrees += (countLeftTrees * countRightTrees);
		}
		return totalTrees;
	}

	public static void main(String[] args) {
		System.out.println(countNumberOfBinaryTrees(1, 3));
	}

}
