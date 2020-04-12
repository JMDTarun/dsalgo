package dsalgo.easy.grokking.dfs.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class AllPathsFoASum {

	// Given a binary tree and a number ‘S’, find all paths from root-to-leaf such
	// that the sum of all the node values of each path equals ‘S’.

	// Preorder - NLR, Inorder - LNR, Postorder - LRN

	public static void findPaths(TreeNode treeNode, int sum, int val, List<List<Integer>> paths, List<Integer> list) {
		if (treeNode == null) {
			return;
		}
		val += treeNode.val;
		list.add(new Integer(treeNode.val));
		if (sum == val && treeNode.left == null && treeNode.right == null) {
			paths.add(new ArrayList<>(list));
		} else {
			findPaths(treeNode.left, sum, val, paths, list);
			findPaths(treeNode.right, sum, val, paths, list);
		}
		val -= treeNode.val;
		list.remove(list.size() - 1);
	}

	public static List<List<Integer>> findAllPaths(TreeNode treeNode, int sum) {
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		findPaths(treeNode, sum, 0, paths, list);
		return paths;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(9);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(2);
		treeNode.right.right = new TreeNode(7);
		System.out.println(findAllPaths(treeNode, 12));
	}

}
