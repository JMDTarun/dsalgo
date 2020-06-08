package dsalgo.easy.grokking.dfs.hard;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class StructurallyUniqueBinarySearchTrees {

	public static List<TreeNode> getTreeNodes(int start, int end) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if (start > end) {
			nodes.add(null);
			return nodes;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodes = getTreeNodes(start, i - 1);
			List<TreeNode> rightNodes = getTreeNodes(i + 1, end);
			for (TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					nodes.add(node);
				}
			}
		}
		return nodes;
	}

	public static void main(String[] args) {
		getTreeNodes(1, 3);
	}

}
