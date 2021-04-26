package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tempList = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				tempList.add(poll.val);

				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			result.add(tempList);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		System.out.println(levelOrder(treeNode));
	}

}
