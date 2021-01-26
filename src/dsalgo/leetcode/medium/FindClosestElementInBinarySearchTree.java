package dsalgo.leetcode.medium;

import dsalgo.common.TreeNode;

public class FindClosestElementInBinarySearchTree {

	public static int maxDiffUtil(TreeNode node, int k) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int diffWithSelf = Math.abs(node.val - k);
		int diffWithChild = k > node.val ? maxDiffUtil(node.right, k) : maxDiffUtil(node.left, k);
		return Math.min(diffWithSelf, diffWithChild);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(9);
		treeNode.left = new TreeNode(4);
		treeNode.right = new TreeNode(17);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(6);
		treeNode.left.right.left = new TreeNode(5);
		treeNode.left.right.right = new TreeNode(7);
		treeNode.right.right = new TreeNode(22);
		treeNode.right.right.left = new TreeNode(20);

		System.out.println(maxDiffUtil(treeNode, 19));

	}
}
