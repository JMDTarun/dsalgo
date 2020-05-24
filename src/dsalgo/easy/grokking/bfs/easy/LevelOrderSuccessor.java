package dsalgo.easy.grokking.bfs.easy;

import java.util.LinkedList;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class LevelOrderSuccessor {

	public static TreeNode findSuccessor(TreeNode treeNode, int key) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.val == key && !queue.isEmpty()) {
					return queue.peek();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(12);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(1);
		treeNode.left.left = new TreeNode(9);
//		treeNode.left.right = new TreeNode(2);
		treeNode.right.left = new TreeNode(10);
		treeNode.right.right = new TreeNode(5);
		TreeNode successor = findSuccessor(treeNode, 5);
		System.out.println(successor);
	}

}
