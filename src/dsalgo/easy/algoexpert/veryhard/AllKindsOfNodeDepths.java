package dsalgo.easy.algoexpert.veryhard;

import dsalgo.common.TreeNode;

public class AllKindsOfNodeDepths {
	// private static int totalDepths = 0;
	public static int countAllNodeDepths(TreeNode treeNode, int depth) {
		if (treeNode == null) {
			return 0;
		}
		if (treeNode.left == null && treeNode.right == null) {
			return depth;
		}
		// int leftDepth = depth + countAllNodeDepths(treeNode.left, depth + 1);
		// int rightDepth = depth + countAllNodeDepths(treeNode.right, depth + 1);
		// return leftDepth + rightDepth;
		int d = depth + countAllNodeDepths(treeNode.left, depth + 1) + countAllNodeDepths(treeNode.right, depth + 1);
		System.out.println(d);
		return d;
	}

	public static int getAllNodeDepths(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		return getAllNodeDepths(treeNode.left) + getAllNodeDepths(treeNode.right) + countAllNodeDepths(treeNode, 0);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.left.left.left = new TreeNode(8);
		treeNode.left.left.right = new TreeNode(9);
		// treeNode.left.left.left.left = new TreeNode(10);
		// treeNode.left.left.left.right = new TreeNode(11);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		System.out.println(getAllNodeDepths(treeNode));
	}
}
