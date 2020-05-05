package dsalgo.easy.grokking.dfs.medium;

import dsalgo.common.TreeNode;

public class PathWithGivenSequence {

	public static boolean findPath(TreeNode treeNode, int[] sequence, int index) {
		if (treeNode == null) {
			return false;
		}
		if (treeNode.val == sequence[index] && treeNode.left == null && treeNode.right == null
				&& index == sequence.length - 1) {
			return true;
		} else if (treeNode.val != sequence[index]) {
			return false;
		}
		return findPath(treeNode.left, sequence, index + 1) || findPath(treeNode.right, sequence, index + 1);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(9);
		treeNode.right.left = new TreeNode(2);
		treeNode.right.right = new TreeNode(9);

		int[] sequence = { 1, 9, 5 };
		System.out.println(findPath(treeNode, sequence, 0));
	}

}
