package dsalgo.easy.grokking.bfs.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class RightViewOfABinaryTree {

	public static List<Integer> rightView(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int size;
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (i == size - 1) {
					list.add(poll.val);
				}
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(12);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(1);
//		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(9);
		treeNode.right.left = new TreeNode(10);
		treeNode.right.right = new TreeNode(5);
		treeNode.left.right.left = new TreeNode(3);
		System.out.println(rightView(treeNode));
	}

}
