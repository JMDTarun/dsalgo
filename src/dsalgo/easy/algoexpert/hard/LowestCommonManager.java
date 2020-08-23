package dsalgo.easy.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.TreeNode;

public class LowestCommonManager {

//	You're given three inputs, all of which are instances of a class that have a "directReports" property
//	pointing to their direct reports. The first input is the top
//	manager in an organizational chart (i.e., the only instance that is not anybody else's direct report),
//	and the other two inputs are reports in the organizational
//	chart. Write a function that returns the lowest common manager to the two reports.
//	Sample input: Node A, Node E, Node I (from the organizational chart below)
//	     A
//	    / \
//	   B   C
//	  / \ / \
//	  D E F G
//	 / \
//	 H  I
//	Sample output: Node B
	
	
	public static boolean getPathOfNode(TreeNode treeNode, List<String> list, String node) {
		if (treeNode == null) {
			return false;
		}
		list.add(treeNode.strVal);
		if (treeNode.strVal.equals(node)) {
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

	public static String findLowestCommonAncestor(TreeNode treeNode, String node1, String node2) {
		List<String> firstPath = new ArrayList<>();
		getPathOfNode(treeNode, firstPath, node1);

		List<String> secondPath = new ArrayList<>();
		getPathOfNode(treeNode, secondPath, node2);
		String lowestCommonAncestor = null;
		for (int i = 0; i < firstPath.size() && i < secondPath.size(); i++) {
			if (!firstPath.get(i).equals(secondPath.get(i))) {
				break;
			} else {
				lowestCommonAncestor = firstPath.get(i);
			}
		}
		return lowestCommonAncestor;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode("A");
		treeNode.left = new TreeNode("B");
		treeNode.right = new TreeNode("C");
		treeNode.left.left = new TreeNode("D");
		treeNode.left.right = new TreeNode("E");
		treeNode.right.left = new TreeNode("F");
		treeNode.right.right = new TreeNode("G");
		treeNode.left.left.left = new TreeNode("H");
		treeNode.left.left.right = new TreeNode("I");

		System.out.println(findLowestCommonAncestor(treeNode, "E", "I"));
	}
	
}
