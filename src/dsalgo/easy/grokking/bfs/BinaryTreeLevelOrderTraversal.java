package dsalgo.easy.grokking.bfs;

import java.util.LinkedList;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	// Given a binary tree, populate an array to represent its level-by-level
	// traversal. You should populate the values of all nodes of each level from
	// left to right in separate sub-arrays.

	private static void levelOrderTravelsal(TreeNode treeNode) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		levelOrderTravelsal(treeNode);
	}

}
