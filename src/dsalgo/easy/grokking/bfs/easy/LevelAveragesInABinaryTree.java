package dsalgo.easy.grokking.bfs.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class LevelAveragesInABinaryTree {

	public static List<Double> findLevelAverages(TreeNode treeNode) {
		List<Double> averages = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			averages.add(sum / size);
		}
		return averages;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(12);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(1);
		treeNode.left.left = new TreeNode(9);
		treeNode.left.right = new TreeNode(2);
		treeNode.right.left = new TreeNode(10);
		treeNode.right.right = new TreeNode(5);
		System.out.println(findLevelAverages(treeNode));
	}

}
