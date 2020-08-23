package dsalgo.easy.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class LowestCommonAncestor {

	public static boolean getPathOfNode(TreeNode treeNode, List<Integer> list, int node) {
		if (treeNode == null) {
			return false;
		}
		list.add(treeNode.val);
		if (treeNode.val == node) {
			return true;
		}
		boolean isInLeft = getPathOfNode(treeNode.left, list, node);
		if (!isInLeft) {
			boolean isInRight = getPathOfNode(treeNode.right, list, node);
			if (!isInRight) {
				list.remove(list.size() - 1);
			}
			return isInRight;
		}
		return isInLeft;
	}

	public static int findLowestCommonAncestor(TreeNode treeNode, int node1, int node2) {
		List<Integer> firstPath = new ArrayList<Integer>();
		getPathOfNode(treeNode, firstPath, node1);

		List<Integer> secondPath = new ArrayList<Integer>();
		getPathOfNode(treeNode, secondPath, node2);
		int lowestCommonAncestor = 0;
		for (int i = 0; i < firstPath.size() && i < secondPath.size(); i++) {
			if (firstPath.get(i) != secondPath.get(i)) {
				break;
			} else {
				lowestCommonAncestor = firstPath.get(i);
			}
		}
		return lowestCommonAncestor;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		System.out.println(findLowestCommonAncestor(treeNode, 2, 4));
	}

}
