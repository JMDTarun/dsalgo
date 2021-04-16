package dsalgo.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class DeepestLeavesSum {

	public static int deepestLeavesSum(TreeNode root) {
		int deepestLevelValue = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		deepestLevelValue = root.val;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (size > 0) {
				deepestLevelValue = 0;
			}
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				deepestLevelValue += poll.val;
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
		}
		return deepestLevelValue;
	}

	private static int maxLevel = 0;
	private static int finalSum = 0;

	public static int deepestLeavesSumRecursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		traverseTree(root, 0);
		return finalSum;
	}

	private static void traverseTree(TreeNode root, int level) {
		if (root == null) {
			return;
		}

		if (level == maxLevel) {
			finalSum += root.val;
		} else if (level > maxLevel) {
			finalSum = 0;
			finalSum += root.val;
			maxLevel = level;
		}
		traverseTree(root.left, level + 1);
		traverseTree(root.right, level + 1);
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.left.left.left = new TreeNode(7);
		treeNode.right.right = new TreeNode(6);
		treeNode.right.right.right = new TreeNode(8);
		System.out.println(deepestLeavesSumRecursive(treeNode));

	}

}
