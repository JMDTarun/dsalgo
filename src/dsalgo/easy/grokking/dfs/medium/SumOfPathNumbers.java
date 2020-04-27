package dsalgo.easy.grokking.dfs.medium;

import dsalgo.common.TreeNode;

public class SumOfPathNumbers {

	public static int findSumOfPathNumbers(TreeNode treeNode, int multiplier, int sum) {
		if (treeNode == null) {
			return -1;
		}
		sum = (sum * multiplier) + treeNode.val;
		if (treeNode.left == null && treeNode.right == null) {
			return sum;
		}
		int leftSum = findSumOfPathNumbers(treeNode.left, multiplier, sum);
		int rightSum = findSumOfPathNumbers(treeNode.right, multiplier, sum);
		return leftSum + rightSum;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(9);
		treeNode.right.left = new TreeNode(2);
		treeNode.right.right = new TreeNode(9);
		System.out.println(findSumOfPathNumbers(treeNode, 10, 0));
	}

}
