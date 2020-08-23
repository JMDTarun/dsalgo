package dsalgo.easy.algoexpert.easy;

import dsalgo.common.TreeNode;

public class NodeDepths {

	public static int countNodeDepths(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		if (treeNode.left == null && treeNode.right == null) {
			return 1;
		}
		int leftDepth = countNodeDepths(treeNode.left) + 1;
		int rightDepth = countNodeDepths(treeNode.right) + 1;
		return leftDepth + rightDepth;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		System.out.println(countNodeDepths(treeNode));
	}

}
