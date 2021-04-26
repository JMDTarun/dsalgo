package dsalgo.leetcode.medium;

import dsalgo.common.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(-3);

		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(2);

		treeNode.left.left.left = new TreeNode(3);
		treeNode.left.left.right = new TreeNode(-2);

		treeNode.left.right.right = new TreeNode(1);

		treeNode.right.right = new TreeNode(11);
		TreeNode p = new TreeNode(-2);

		TreeNode q = new TreeNode(11);

		lowestCommonAncestor(treeNode, p, q);
	}

}
