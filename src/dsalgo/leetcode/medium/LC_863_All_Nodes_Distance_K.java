package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class LC_863_All_Nodes_Distance_K {

	private static boolean isInLeft = false;
	private static TreeNode targetNode = null;

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<Integer>();
		distanceK(root, target, k, result);
		return result;
	}

	private static void distanceK(TreeNode root, TreeNode target, int k, List<Integer> result) {
		if (root == null) {
			return;
		}
		distanceKForAllNodes(root, target, k, result);
		distanceK(root.left, target, k, result);
		distanceK(root.right, target, k, result);
	}

	public static void distanceKForAllNodes(TreeNode root, TreeNode target, int k, List<Integer> result) {
		int distanceFromRoot = getDistanceFromRoot(root, target, 0);
		if (distanceFromRoot > -1) {
			if (distanceFromRoot == k && !result.contains(root.val)) {
				result.add(root.val);
			} else {
				getAllNodesKDistanceApart(targetNode, k, 0, result);
				if (isInLeft) {
					getAllNodesKDistanceApart(root.right, k, distanceFromRoot + 1, result);
				} else {
					getAllNodesKDistanceApart(root.left, k, distanceFromRoot + 1, result);
				}
			}
		}
	}

	private static void getAllNodesKDistanceApart(TreeNode node, int k, int level, List<Integer> result) {
		if (node == null || level > k) {
			return;
		}
		if (k == level && !result.contains(node.val)) {
			result.add(node.val);
		}
		getAllNodesKDistanceApart(node.left, k, level + 1, result);
		getAllNodesKDistanceApart(node.right, k, level + 1, result);
	}

	private static int getDistanceFromRoot(TreeNode root, TreeNode target, int level) {
		if (root == null) {
			return -1;
		}
		if (target.val == root.val) {
			targetNode = root;
			return level;
		}
		int left = getDistanceFromRoot(root.left, target, level + 1);
		if (left > -1) {
			isInLeft = true;
			return left;
		}
		int right = getDistanceFromRoot(root.right, target, level + 1);
		if (right > -1) {
			isInLeft = false;
			return right;
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(0);
		treeNode.left = new TreeNode(1);
//		treeNode.right = new TreeNode(1);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(2);
//		treeNode.left.right.left = new TreeNode(7);
//		treeNode.left.right.right = new TreeNode(4);

//		treeNode.right.left = new TreeNode(0);
//		treeNode.right.right = new TreeNode(8);

		System.out.println(distanceK(treeNode, treeNode.left.right, 1));
	}

}
