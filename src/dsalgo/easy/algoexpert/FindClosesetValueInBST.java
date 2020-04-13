package dsalgo.easy.algoexpert;

import dsalgo.common.TreeNode;

public class FindClosesetValueInBST {

	private static Integer tnValue = null;

	private static int findClosestValueInBST(TreeNode treeNode, int value, Integer closestValue) {
		if (treeNode == null) {
			return -1;
		}
		if (Math.abs(treeNode.val - value) < closestValue) {
			closestValue = Math.abs(treeNode.val - value);
			tnValue = treeNode.val;
		}
		findClosestValueInBST(treeNode.left, value, closestValue);
		findClosestValueInBST(treeNode.right, value, closestValue);
		return tnValue;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(15);
		treeNode.left.left = new TreeNode(5);
		treeNode.left.right = new TreeNode(9);
		treeNode.right.left = new TreeNode(14);
		treeNode.right.right = new TreeNode(19);
		System.out.println(findClosestValueInBST(treeNode, 16, Integer.MAX_VALUE));
	}

}
