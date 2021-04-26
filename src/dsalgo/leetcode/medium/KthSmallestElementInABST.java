package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class KthSmallestElementInABST {

	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		kthSmallestHelper(root, k, list);
		return list.get(k - 1);
	}

	public static void kthSmallestHelper(TreeNode root, int k, List<Integer> list) {
		if (root == null) {
			return;
		}
		kthSmallestHelper(root.left, k, list);
		list.add(root.val);
		kthSmallestHelper(root.right, k, list);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(5);
		treeNode.left = new TreeNode(3);
		treeNode.right = new TreeNode(6);
		treeNode.left.left = new TreeNode(2);
		treeNode.left.right = new TreeNode(4);
		treeNode.left.left.left = new TreeNode(1);
		System.out.println(kthSmallest(treeNode, 3));
	}

}
