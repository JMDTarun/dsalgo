package dsalgo.leetcode.medium;

import dsalgo.common.TreeNode;

public class LeetCode530_MinimumAbsoluteDifferenceInBST {

	private static int min = Integer.MAX_VALUE;
	private static TreeNode pre = null;

	public static int getMinimumDifference(TreeNode root) {
		inOrder(root);
		return min;
	}

	private static void inOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		inOrder(treeNode.left);
		if (pre != null) {
			min = Math.min(min, treeNode.val - pre.val);
		}
		pre = treeNode;
		inOrder(treeNode.right);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(2);
		System.out.println(getMinimumDifference(treeNode));
	}

}
