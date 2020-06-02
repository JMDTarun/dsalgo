package dsalgo.easy.grokking.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class ConnectAllLevelOrderSiblings {

	public static void connect(TreeNode treeNode) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);
		int size;
		TreeNode previous = treeNode;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (poll.left != null) {
					if (previous != null) {
						previous.next = poll.left;
						previous = poll.left;
					} else {
						previous = poll.left;
					}
					queue.add(poll.left);
				}
				if (poll.right != null) {
					if (previous != null) {
						previous.next = poll.right;
						previous = poll.right;
					} else {
						previous = poll.right;
					}
					queue.add(poll.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		connect(treeNode);

		TreeNode current = treeNode;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

}
