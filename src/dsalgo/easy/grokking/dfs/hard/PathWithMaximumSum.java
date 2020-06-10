package dsalgo.easy.grokking.dfs.hard;

import dsalgo.common.TreeNode;

public class PathWithMaximumSum {

	private static int maxPath = 0;

	public static int findMaximumPath(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}

		int leftMax = findMaximumPath(treeNode.left);
		int rightMax = findMaximumPath(treeNode.right);
		maxPath = treeNode.val + leftMax + rightMax;
		return treeNode.val + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.right.left = new TreeNode(5);
		treeNode.right.right = new TreeNode(6);
		findMaximumPath(treeNode);
		System.out.println(maxPath);
	}

}
