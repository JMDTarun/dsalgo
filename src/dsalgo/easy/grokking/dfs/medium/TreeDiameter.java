package dsalgo.easy.grokking.dfs.medium;

import dsalgo.common.TreeNode;

public class TreeDiameter {

	private static int diameter = 0;

	public static int findDiameter(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		}
		treeNode.print(treeNode);
		int leftMax = findDiameter(treeNode.left);
		int rightMax = findDiameter(treeNode.right);
		int sum = leftMax + rightMax + 1;
		diameter = Math.max(diameter, sum);
		return Math.max(leftMax, rightMax) + 1;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.right.left = new TreeNode(5);
		treeNode.right.right = new TreeNode(6);
		findDiameter(treeNode);
		System.out.println(diameter);

	}

}
