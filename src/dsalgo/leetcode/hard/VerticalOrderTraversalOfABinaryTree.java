package dsalgo.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dsalgo.common.TreeNode;

public class VerticalOrderTraversalOfABinaryTree {

	private static Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>((n1, n2) -> n2 - n1);

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		verticalOrder(root, 0);
		return new ArrayList<List<Integer>>(map.values());
	}

	private static void verticalOrder(TreeNode node, int level) {
		if (node == null) {
			return;
		}

		if (map.containsKey(level)) {
			map.get(level).add(node.val);
		} else {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(node.val);
			map.put(level, temp);
		}

		verticalOrder(node.left, level + 1);
		verticalOrder(node.right, level - 1);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		verticalTraversal(root);
	}

}
