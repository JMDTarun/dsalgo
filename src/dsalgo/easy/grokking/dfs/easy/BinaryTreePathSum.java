package dsalgo.easy.grokking.dfs.easy;

import dsalgo.common.TreeNode;

public class BinaryTreePathSum {

	// Given a binary tree and a number ‘S’, find if the tree has a path from
	// root-to-leaf such that the sum of all the node values of that path equals
	// ‘S’.

	// Preorder - NLR, LNR - Inorder, LRN - Postorder

	public static boolean hasPath(TreeNode treeNode, int sum, int val) {
		if (treeNode == null) {
			if (val == sum) {
				return true;
			}
			return false;
		}
		val += treeNode.val;
		boolean isLeftPathExists = hasPath(treeNode.left, sum, val);
		boolean isRightPathExists = hasPath(treeNode.right, sum, val);
		val -= treeNode.val;
		if (isRightPathExists || isLeftPathExists) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasValidPath(TreeNode treeNode, int sum, int val) {
		if (treeNode == null) {
			return false;
		}
		val += treeNode.val;
		if (sum == val && treeNode.left == null && treeNode.right == null) {
			return true;
		}
		boolean isLeftPathExists = hasPath(treeNode.left, sum, val);
		boolean isRightPathExists = hasPath(treeNode.right, sum, val);
		if (isRightPathExists || isLeftPathExists) {
			val -= treeNode.val;
			return true;
		} else {
			val -= treeNode.val;
			return false;
		}
	}

	public static void prePrderTraversal(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.val);

		prePrderTraversal(treeNode.left);
		prePrderTraversal(treeNode.right);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		// prePrderTraversal(treeNode);

		boolean isPathExist = hasValidPath(treeNode, 11, 0);
		System.out.println(isPathExist);
	}

}
