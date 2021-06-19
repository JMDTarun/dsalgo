package dsalgo.leetcode.medium;

import dsalgo.common.TreeNode;

public class ValidateBinarySearchTree {

	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		if ((max != null && node.val >= max) || (min != null && node.val <= min)) {
			return false;
		}
		return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(1);
//		treeNode.right = new TreeNode(6);
//		treeNode.right.left = new TreeNode(3);
//		treeNode.right.right = new TreeNode(6);
//		treeNode.left.left.left = new TreeNode(1);
		System.out.println(isValidBST(treeNode));
	}

}
