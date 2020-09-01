package dsalgo.easy.algoexpert.veryhard;

import dsalgo.common.TreeNode;

public class AllKindsOfNodeDepths {
	private static int totalDepths = 0;
	public static void countAllNodeDepths(TreeNode treeNode, int fromTop, int fromBottom) {
		if (treeNode == null) {
			return;
		}
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}
		fromTop++;
		countAllNodeDepths(treeNode.left, fromTop, fromBottom);
		fromBottom++;
		if (treeNode.right != null) {
			fromTop *= 2;
		}
		countAllNodeDepths(treeNode.right, fromTop, fromBottom);
		fromBottom++;
		totalDepths += fromBottom + fromTop;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.left.left.left = new TreeNode(8);
		treeNode.left.left.right = new TreeNode(9);
		treeNode.left.left.left.left = new TreeNode(10);
		treeNode.left.left.left.right = new TreeNode(11);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		countAllNodeDepths(treeNode, 0, 0);
		System.out.println(totalDepths - 1);
	}
}
