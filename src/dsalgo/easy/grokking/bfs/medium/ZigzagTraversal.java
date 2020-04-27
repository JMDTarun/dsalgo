package dsalgo.easy.grokking.bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class ZigzagTraversal {

	public static List<List<Integer>> traverse(TreeNode treeNode) {
		List<List<Integer>> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);
		int size;
		boolean isReverse = false;
		while (!queue.isEmpty()) {
			size = queue.size();
			List<Integer> values = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (isReverse) {
					values.add(0, poll.val);
				} else {
					values.add(poll.val);	
				}
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			isReverse = !isReverse;
			list.add(values);
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		System.out.println(traverse(treeNode));
	}

}
