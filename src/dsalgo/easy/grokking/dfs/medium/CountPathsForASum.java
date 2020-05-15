package dsalgo.easy.grokking.dfs.medium;

import java.util.LinkedList;
import java.util.List;

import dsalgo.common.TreeNode;

public class CountPathsForASum {

	private static int pathsFound = 0;

	public static int countPaths(TreeNode treeNode, int sum, int sumUntilNow, int paths, List<Integer> travesedValues) {
		if (treeNode == null) {
			return -1;
		}
		travesedValues.add(treeNode.val);
		sumUntilNow += treeNode.val;
		if (sumUntilNow == sum) {
			pathsFound++;
		}
		if (sumUntilNow >= sum) {
			int i = 0;
			while (sumUntilNow >= sum && i < travesedValues.size()) {
				sumUntilNow -= travesedValues.get(0);
				if (sumUntilNow == sum) {
					pathsFound++;
				}
				travesedValues.remove(0);
				i++;
			}
		}
		if (treeNode.left == null && treeNode.right == null) {
			return pathsFound;
		}
		countPaths(treeNode.left, sum, sumUntilNow, paths, new LinkedList<Integer>(travesedValues));
		countPaths(treeNode.right, sum, sumUntilNow, paths, new LinkedList<Integer>(travesedValues));
		return pathsFound;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(9);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(2);
		treeNode.right.right = new TreeNode(7);
		treeNode.left.left.left = new TreeNode(6);
		treeNode.left.left.left.left = new TreeNode(6);
		treeNode.left.right.left = new TreeNode(4);
		treeNode.left.right.right = new TreeNode(3);
		treeNode.left.right.left.left = new TreeNode(3);
		System.out.println(countPaths(treeNode, 12, 0, 0, new LinkedList<Integer>()));
	}

}
