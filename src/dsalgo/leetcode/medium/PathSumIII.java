package dsalgo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import dsalgo.common.TreeNode;

public class PathSumIII {

	public static int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		hashMap.put(0, 1);
		int sum = pathSum(root, targetSum, 0, hashMap);
		return sum;
	}

	private static int pathSum(TreeNode root, int targetSum, int currentSum, Map<Integer, Integer> paths) {
		if (root == null) {
			return 0;
		}
		currentSum += root.val;
		int sum = 0;
		if (paths.containsKey(currentSum - targetSum)) {
			sum += paths.get(currentSum - targetSum);
		}

		if (paths.containsKey(currentSum)) {
			paths.put(currentSum, paths.get(currentSum) + 1);
		} else {
			paths.put(currentSum, 1);
		}
		sum += pathSum(root.left, targetSum, currentSum, paths) + pathSum(root.right, targetSum, currentSum, paths);
		paths.put(currentSum, paths.get(currentSum) - 1);
		return sum;
	}

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(-3);

		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(2);

		treeNode.left.left.left = new TreeNode(3);
		treeNode.left.left.right = new TreeNode(-2);

		treeNode.left.right.right = new TreeNode(1);

		treeNode.right.right = new TreeNode(11);

		System.out.println(pathSum(treeNode, 8));
	}

}
