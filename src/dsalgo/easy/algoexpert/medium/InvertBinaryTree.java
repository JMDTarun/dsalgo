package dsalgo.easy.algoexpert.medium;

import dsalgo.common.TreeNode;

public class InvertBinaryTree {
	//  https://leetcode.com/problems/invert-binary-tree/
	//	Invert a binary tree.
	//
	//	Example:
	//
	//	Input:
	//
	//	     4
	//	   /   \
	//	  2     7
	//	 / \   / \
	//	1   3 6   9
	//	Output:
	//
	//	     4
	//	   /   \
	//	  7     2
	//	 / \   / \
	//	9   6 3   1

	
	public static void invertBinaryTree(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}

		if (treeNode.left == null && treeNode.right == null) {
			return;
		}

		TreeNode temp = treeNode.left;
		treeNode.left = treeNode.right;
		treeNode.right = temp;

		invertBinaryTree(treeNode.left);
		invertBinaryTree(treeNode.right);

	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(4);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(7);
		treeNode.left.left = new TreeNode(1);
		treeNode.left.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(9);
		invertBinaryTree(treeNode);
		treeNode.print(treeNode);
		
		
	}	

}
