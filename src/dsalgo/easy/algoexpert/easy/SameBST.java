package dsalgo.easy.algoexpert.easy;

import dsalgo.common.TreeNode;

public class SameBST {

	// Given two binary trees, write a function to check if they are the same or
	// not.
	//
	// Two binary trees are considered the same if they are structurally identical
	// and the nodes have the same value.
	//
	// Example 1:
	//
	// Input: 1 1
	// / \ / \
	// 2 3 2 3
	//
	// [1,2,3], [1,2,3]
	//
	// Output: true
	// Example 2:
	//
	// Input: 1 1
	// / \
	// 2 2
	//
	// [1,2], [1,null,2]
	//
	// Output: false
	// Example 3:
	//
	// Input: 1 1
	// / \ / \
	// 2 1 1 2
	//
	// [1,2,1], [1,1,2]
	//
	// Output: false

	public static boolean sameBST(TreeNode treeNode1, TreeNode treeNode2) {
		if (treeNode1 == null && treeNode2 == null) {
			return true;
		}

		if ((treeNode1 != null && treeNode2 == null) || (treeNode1 == null && treeNode2 != null)) {
			return false;
		}

		if (treeNode1.val != treeNode2.val) {
			return false;
		} else {
			boolean isLeftSame = sameBST(treeNode1.left, treeNode2.left);
			boolean isRightSame = sameBST(treeNode1.right, treeNode2.right);
			if (isLeftSame != isRightSame) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		TreeNode treeNode1 = new TreeNode(1);
		treeNode1.left = new TreeNode(2);
		treeNode1.right = new TreeNode(3);
		treeNode1.left.left = new TreeNode(4);
		treeNode1.left.right = new TreeNode(5);
		treeNode1.right.left = new TreeNode(6);
		treeNode1.right.right = new TreeNode(7);

		System.out.println(sameBST(treeNode, treeNode1));
	}

}
